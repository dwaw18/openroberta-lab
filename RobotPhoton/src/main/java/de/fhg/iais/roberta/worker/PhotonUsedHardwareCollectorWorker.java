package de.fhg.iais.roberta.worker;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.components.Project;
import de.fhg.iais.roberta.visitor.PhotonUsedHardwareCollectorVisitor;
import de.fhg.iais.roberta.visitor.validate.AbstractCollectorVisitor;

public final class PhotonUsedHardwareCollectorWorker extends AbstractUsedHardwareCollectorWorker {
    @Override
    protected AbstractCollectorVisitor getVisitor(
        Project project, ClassToInstanceMap<IProjectBean.IBuilder<?>> beanBuilders) {
        return new PhotonUsedHardwareCollectorVisitor(project.getConfigurationAst(), beanBuilders);
    }
}