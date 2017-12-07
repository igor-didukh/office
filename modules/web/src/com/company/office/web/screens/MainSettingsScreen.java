package com.company.office.web.screens;

import com.company.office.OfficeConfig;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;

import javax.inject.Inject;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @Inject
    private Metadata metadata;

    @Inject
    private FileLoader fileLoader;

    @Inject
    private ExportDisplay exportDisplay;



    public void onBtnDownloadClick() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        FileDescriptor fileDescriptor = metadata.create(FileDescriptor.class);
        //FileDescriptor fileDescriptor = new FileDescriptor();
        fileDescriptor.setName("ssh access to github.pdf");
        //fileDescriptor.setId("e778b81f-4e64-5094-6c5a-c65fcf205136");
        try {
            fileDescriptor.setCreateDate(dateFormat.parse("2017-12-07 16:09:35"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        exportDisplay.show(fileDescriptor, ExportFormat.OCTET_STREAM);



    }
}