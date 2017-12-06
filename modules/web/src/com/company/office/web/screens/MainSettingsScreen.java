package com.company.office.web.screens;

import com.company.office.OfficeConfig;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import java.util.Map;

public class MainSettingsScreen extends AbstractWindow {
    @Inject
    private TextField txtCompanyName;

    @Inject
    private LookupField lookupApplicantsGroup;

    @Inject
    private LookupField lookupWorkersGroup;

    @Inject
    private OfficeConfig officeConfig;

    @Override
    public void init(Map<String, Object> params) {
        if (officeConfig.getCompanyName() != null)
            txtCompanyName.setValue(officeConfig.getCompanyName());

        if (officeConfig.getApplicantsGroup() != null)
            lookupApplicantsGroup.setValue(officeConfig.getApplicantsGroup());

        if (officeConfig.getWorkersGroup() != null)
            lookupWorkersGroup.setValue(officeConfig.getWorkersGroup());
    }

    public void onBtnOkClick() {
        showOptionDialog(
                getMessage("settingsDialog.saveAndClose.title"),
                getMessage("settingsDialog.saveAndClose.msg"),
                MessageType.CONFIRMATION,
                new Action[] {
                        new DialogAction(DialogAction.Type.YES, Action.Status.NORMAL).withHandler(e -> {
                            if (lookupApplicantsGroup.getValue() == null) {
                                showMessageDialog(
                                        getMessage("settingsDialog.warning.empty.title"),
                                        getMessage("settingsDialog.warning.empty.applicantsGroup"),
                                        MessageType.WARNING.modal(true).closeOnClickOutside(true)
                                );
                                return;
                            }

                            if (lookupWorkersGroup.getValue() == null) {
                                showMessageDialog(
                                        getMessage("settingsDialog.warning.empty.title"),
                                        getMessage("settingsDialog.warning.empty.workersGroup"),
                                        MessageType.WARNING.modal(true).closeOnClickOutside(true)
                                );
                                return;
                            }

                            if (lookupApplicantsGroup.getValue() == lookupWorkersGroup.getValue()) {
                                showMessageDialog(
                                        getMessage("settingsDialog.warning.equals.title"),
                                        getMessage("settingsDialog.warning.equals.msg"),
                                        MessageType.WARNING.modal(true).closeOnClickOutside(true)
                                );
                                return;
                            }

                            officeConfig.setCompanyName(txtCompanyName.getValue());
                            officeConfig.setApplicantsGroup(lookupApplicantsGroup.getValue());
                            officeConfig.setWorkersGroup(lookupWorkersGroup.getValue());

                            this.close("");
                        }),
                        new DialogAction(DialogAction.Type.NO, Action.Status.PRIMARY)
                }
        );
    }

    public void onBtnCancelClick() {
        this.close("");
    }
}