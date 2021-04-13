package de.fhg.iais.roberta.worker;

import de.fhg.iais.roberta.bean.UsedHardwareBean;
import de.fhg.iais.roberta.components.Project;
import de.fhg.iais.roberta.visitor.PhotonStackMachineVisitor;
import de.fhg.iais.roberta.visitor.lang.codegen.AbstractStackMachineVisitor;

public final class PhotonStackMachineGeneratorWorker extends AbstractStackMachineGeneratorWorker {
    @Override
    protected AbstractStackMachineVisitor<Void> getVisitor(Project project, UsedHardwareBean usedHardwareBean) {
        return new PhotonStackMachineVisitor<>(project.getConfigurationAst(), project.getProgramAst().getTree(), project.getLanguage());
    }
}
