/* * ATM Example system - file LogPanel.java   * * copyright (c) 2001 - Russell C. Bjork * */ package simulation;import java.awt.*;import java.awt.event.*;/** The GUI panel that displays the ATM's internal log */public class LogPanel extends Panel{    /** Constructor     *     *  @param gui the the overall GUI     */         public LogPanel(final GUI gui)    {        GridBagLayout logLayout = new GridBagLayout();        setLayout(logLayout);        setFont(new Font("Monospaced", Font.PLAIN, 14));                Label logPanelLabel = new Label("Log", Label.CENTER);        add(logPanelLabel);        GridBagConstraints constraints =             GUI.makeConstraints(0, 0, 1, 1, GridBagConstraints.NONE);        constraints.weighty = 0;        logLayout.setConstraints(logPanelLabel, constraints);                     logPrintArea = new TextArea();        logPrintArea.setBackground(Color.white);        logPrintArea.setForeground(Color.black);        logPrintArea.setFont(new Font("Monospaced", Font.PLAIN, 12));        logPrintArea.setEditable(false);                add(logPrintArea);        constraints = GUI.makeConstraints(1, 0, 1, 1, GridBagConstraints.BOTH);        constraints.weighty = 1;        logLayout.setConstraints(logPrintArea, constraints);                Panel logButtonPanel = new Panel();        logButtonPanel.setLayout(new FlowLayout());                Button clearLogButton = new Button("Clear Log");        clearLogButton.addActionListener(new ActionListener() {            public void actionPerformed(ActionEvent e)            {                logPrintArea.setText("");            }        });        logButtonPanel.add(clearLogButton);                Button dismissLogButton = new Button(" Hide Log ");        dismissLogButton.addActionListener(new ActionListener() {            public void actionPerformed(ActionEvent e)            {                gui.showCard("ATM");            }        });                logButtonPanel.add(dismissLogButton);        add(logButtonPanel);        constraints = GUI.makeConstraints(2, 0, 1, 1, GridBagConstraints.NONE);        constraints.weighty = 0;        logLayout.setConstraints(logButtonPanel, constraints);    }        /** Add text to the log     *     *  @param text the text to be printed     */    public void println(String text)    {        logPrintArea.append(text + "\n");    }        // Returns a String representation of the log    public String getLog(){    	return logPrintArea.getText();    }        /** Area into which the log is to be printed     */    private TextArea logPrintArea;}                    