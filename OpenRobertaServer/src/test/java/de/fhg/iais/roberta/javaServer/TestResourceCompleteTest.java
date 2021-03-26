package de.fhg.iais.roberta.javaServer;

import com.google.common.collect.Streams;
import de.fhg.iais.roberta.factory.IRobotFactory;
import de.fhg.iais.roberta.util.Util;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(Parameterized.class)
public class TestResourceCompleteTest {

    private static final Path commonResourcesPath = Paths.get("src/test/resources/crossCompilerTests/common");
    private static final Path specificResourcesPath = Paths.get("src/test/resources/crossCompilerTests/robotSpecific");
    private static final JSONObject testSpecification = Util.loadYAML("classpath:/crossCompilerTests/testSpec.yml");
    private static final JSONObject robots = testSpecification.getJSONObject("robots");

    private static Set<String> presentBlockTypes;

    private String robot;
    private String toolbox;
    private String block;

    public TestResourceCompleteTest(String robot, String toolbox, String block) {
        this.robot = robot;
        this.toolbox = toolbox;
        this.block = block;
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        presentBlockTypes = Streams.concat(Files.walk(commonResourcesPath), Files.walk(specificResourcesPath))
            .filter(file -> file.getFileName().toString().endsWith(".xml"))
            .filter(file -> !file.getParent().startsWith("_"))
            .filter(file -> file.toFile().isFile())
            .map(file -> Util.readFileContent(file.toString()))
            .map(TestResourceCompleteTest::parseBlockTypes)
            .flatMap(Collection::stream)
            .collect(Collectors.toSet());
    }

    @Parameterized.Parameters(name = "{0} - {1} toolbox, block=\"{2}\"")
    public static Collection<Object[]> data() {
        return robots.keySet().stream()
            .map(robot -> Util.configureRobotPlugin(robot, "", "", new ArrayList<>()))
            .flatMap(robotFactory -> Stream.of(generateTestDataForRobotFactory(robotFactory, true), generateTestDataForRobotFactory(robotFactory, false)))
            .flatMap(Collection::stream)
            .map(Arrays::asList)
            .collect(Collectors.toSet())
            .stream()
            .map(list -> new String[]{list.get(0), list.get(1), list.get(2)})
            .sorted(Comparator.comparing(s -> s[0]))
            .collect(Collectors.toList());
    }

    private static Collection<String[]> generateTestDataForRobotFactory(IRobotFactory robotFactory, boolean beginner) {
        Set<String> blocks = parseBlockTypes(beginner ? robotFactory.getProgramToolboxBeginner() : robotFactory.getProgramToolboxExpert());

        String robotName = robotFactory.getGroup();
        String toolbox = beginner ? "beginner" : "expert";
        return blocks.stream()
            .map(blockType -> new String[] {robotName, toolbox, blockType})
            .collect(Collectors.toList());
    }

    private static Set<String> parseBlockTypes(String content) {
        Pattern pattern = Pattern.compile("block[^>]+type=\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(content);

        Set<String> blocks = new HashSet<>();

        while ( matcher.find() ) {
            blocks.add(matcher.group(1));
        }
        return blocks;
    }

    @Test
    public void toolBoxBlockIsPresentInTestResources() {
        Assertions.assertThat(presentBlockTypes).contains(block);
    }
}
