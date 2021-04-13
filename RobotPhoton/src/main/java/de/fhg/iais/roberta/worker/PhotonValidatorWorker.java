package de.fhg.iais.roberta.worker;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.components.Project;
import de.fhg.iais.roberta.visitor.PhotonBrickValidatorVisitor;
import de.fhg.iais.roberta.visitor.validate.AbstractProgramValidatorVisitor;

public class PhotonValidatorWorker extends AbstractValidatorWorker {

    @Override
    protected AbstractProgramValidatorVisitor getVisitor(Project project, ClassToInstanceMap<IProjectBean.IBuilder<?>> beanBuilders) {
        return new PhotonBrickValidatorVisitor(project.getConfigurationAst(), beanBuilders);
    }
}