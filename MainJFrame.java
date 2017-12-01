import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Timer;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Matt
 */
public class MainJFrame extends javax.swing.JFrame {
    HashMap<String, Student> 
            masterAll           = new HashMap<>(),
            masterWantsRoommate = new HashMap<>();
    
    ArrayList<Student> 
            overflow              = new ArrayList<>(),
            boysByGradYear        = new ArrayList<>(),
            girlsByGradYear       = new ArrayList<>();
    ArrayList<Roommates> 
            wantsRoommateOverflow = new ArrayList<>();
    
    Brady bradyHall;
    OsbornLarge osbornHallLargeSide;
    OsbornSmall osbornHallSmallSide;
    Village studentVillage;
    Moloney moloneyApartments;
    Neveu neveuApartments;
    Townhouse townhouses;
//    Boolean wantsRoommate = false;
	
	private Integer
			totalCalls = 0,
			bradyCalls = 0,
			osbornSmallCalls = 0,
			osbornLargeCalls = 0,
			villageCalls = 0,
			neveuCalls = 0,
			townhouseCalls = 0,
			moloneyCalls = 0;
    
    DefaultListModel listModel = new DefaultListModel();
    

    public MainJFrame() 
    {
        initComponents();
            load();
        txtSearchJList.addCaretListener(new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
            //System.out.println(txtSearchJList.getText());
            if(!txtSearchJList.getText().equals("") )
            {//textbox is NOT empty
                HashMap<String, Student> newList = new HashMap<>();
                Set<Map.Entry<String, Student> > allSet = masterAll.entrySet();
                Student newOne = new Student();
                
                listModel.clear();//start fresh
                
                for(Entry<String, Student> i : allSet)
                {//search all students for the requested text
                    newOne = (Student) i.getValue();
                    String line = newOne.getLastName() + ", " + newOne.getFirstName() + " - A" + newOne.getID();
                    if(line.contains(txtSearchJList.getText() ) )
                    {//all matches are stored in newList
                        newList.put(newOne.getID(), newOne);
                    }
                }
                if(newList.size() > 0)
                {//search box actually matched something
                    Set<Map.Entry<String, Student> > newSet = newList.entrySet();
                    String[] myArr1 = new String[newList.size()];
                    Student other = new Student();
                    for(Entry<String, Student> j : newSet)
                    {//create new listModel
                        other = (Student) j.getValue();
                        String line = other.getLastName() + ", " + other.getFirstName() + " - A" + other.getID();
                        listModel.addElement(line);
                    }
                    
                    listModel.copyInto(myArr1);//populate array
                    Arrays.sort(myArr1);//sort array
                    listModel.clear();//clear model
                    for(String k : myArr1)
                    {
                        listModel.addElement(k);//add into listModel, sorted
                    }
                    jList2.setModel(listModel);//display sorted list
                    
                }
                else
                {
                    listModel.clear();
                    jList2.setModel(listModel);
                }
            }
            else
            {//textbox IS empty - repopulate listModel with everyone
                listModel.clear();
                Set<Map.Entry<String, Student> > allSet = masterAll.entrySet();
                String[] myArr = new String[masterAll.size() ];
                Student newOne = new Student();
                for(Entry<String, Student> i : allSet)
                {
                    newOne = (Student) i.getValue();
                    listModel.addElement(newOne.getLastName() + ", " + newOne.getFirstName() + " - A" + newOne.getID());
                }
                listModel.copyInto(myArr);//populate array
                Arrays.sort(myArr);//sort array
                listModel.clear();//clear model
                for(String i : myArr)
                {
                    listModel.addElement(i);//add into listModel, sorted
                }
                jList2.setModel(listModel);//display sorted list
            }

        }
        });
        bradyHall           = new Brady();
		osbornHallLargeSide = new OsbornLarge();
		osbornHallSmallSide = new OsbornSmall();
		studentVillage      = new Village();
		moloneyApartments   = new Moloney();
		neveuApartments     = new Neveu();
		townhouses          = new Townhouse();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        dropGender = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        btnNext1 = new javax.swing.JButton();
        txtLastName = new javax.swing.JTextField();
        lblFirstName1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ftxtGradYear = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtFirstNameError = new javax.swing.JLabel();
        txtLastNameError = new javax.swing.JLabel();
        txtIDError = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtSearchJList = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rBtnRoomStudy = new javax.swing.JRadioButton();
        rBtnRoomSocial = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rBtnSigOtherIDC = new javax.swing.JRadioButton();
        rBtnSigOtherNo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rBtnSmokeYes = new javax.swing.JRadioButton();
        rBtnSmokeNo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        rBtnRmSmokeYes = new javax.swing.JRadioButton();
        rBtnRmSmokeNo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rBtnBedTimeEarly = new javax.swing.JRadioButton();
        rBtnBedTimeLate = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rBtnNotNeat = new javax.swing.JRadioButton();
        rBtnNeat = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        rBtnIgnoreNoise = new javax.swing.JRadioButton();
        rBtnQuietStudy = new javax.swing.JRadioButton();
        rBtnWantNoise = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        rBtnBorrowNever = new javax.swing.JRadioButton();
        rBtnBorrowAsk = new javax.swing.JRadioButton();
        rBtnBorrowIDC = new javax.swing.JRadioButton();
        btnNext2 = new javax.swing.JButton();
        lblSmokeError = new javax.swing.JLabel();
        lblRmSmokeError = new javax.swing.JLabel();
        lblNeatError = new javax.swing.JLabel();
        lblBedtimeError = new javax.swing.JLabel();
        lblStudyingError = new javax.swing.JLabel();
        lblSocialError = new javax.swing.JLabel();
        lblBorrowError = new javax.swing.JLabel();
        lblSigOtherError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cBoxVideoGaming = new javax.swing.JCheckBox();
        cBoxInternetSurfing = new javax.swing.JCheckBox();
        cBoxOutdoorActivities = new javax.swing.JCheckBox();
        cBoxTelevisionMovies = new javax.swing.JCheckBox();
        cBoxCrafting = new javax.swing.JCheckBox();
        cBoxHiking = new javax.swing.JCheckBox();
        cBoxPhotography = new javax.swing.JCheckBox();
        cBoxExercising = new javax.swing.JCheckBox();
        cBoxSocializing = new javax.swing.JCheckBox();
        cBoxReading = new javax.swing.JCheckBox();
        cBoxSports = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cBoxVolleyball = new javax.swing.JCheckBox();
        cBoxGolfing = new javax.swing.JCheckBox();
        cBoxDiving = new javax.swing.JCheckBox();
        cBoxSwimming = new javax.swing.JCheckBox();
        cBoxTennis = new javax.swing.JCheckBox();
        cBoxFootball = new javax.swing.JCheckBox();
        cBoxBaseball = new javax.swing.JCheckBox();
        cBoxSoccer = new javax.swing.JCheckBox();
        cBoxBasketball = new javax.swing.JCheckBox();
        cBoxRollerblading = new javax.swing.JCheckBox();
        cBoxSnowboarding = new javax.swing.JCheckBox();
        cBoxFishing = new javax.swing.JCheckBox();
        cBoxBiking = new javax.swing.JCheckBox();
        cBoxHunting = new javax.swing.JCheckBox();
        cBoxHockey = new javax.swing.JCheckBox();
        cBoxSkating = new javax.swing.JCheckBox();
        cBoxKayaking = new javax.swing.JCheckBox();
        cBoxRock = new javax.swing.JCheckBox();
        cBoxPop = new javax.swing.JCheckBox();
        cBoxCountry = new javax.swing.JCheckBox();
        cBoxClassical = new javax.swing.JCheckBox();
        cBoxHipHop = new javax.swing.JCheckBox();
        cBoxDance = new javax.swing.JCheckBox();
        cBoxTechno = new javax.swing.JCheckBox();
        cBoxMetal = new javax.swing.JCheckBox();
        cBoxRap = new javax.swing.JCheckBox();
        cBoxGospel = new javax.swing.JCheckBox();
        cBoxOther = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtOtherMusic = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rBtn1Brady2s = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rBtn1Brady4q = new javax.swing.JRadioButton();
        rBtn1Brady2q = new javax.swing.JRadioButton();
        rBtn1Osborns = new javax.swing.JRadioButton();
        rBtn1Villages = new javax.swing.JRadioButton();
        rBtn1Villageq = new javax.swing.JRadioButton();
        rBtn1Town = new javax.swing.JRadioButton();
        rBtn1Brady4s = new javax.swing.JRadioButton();
        rBtn1Osbornq = new javax.swing.JRadioButton();
        rBtn1Moloney = new javax.swing.JRadioButton();
        rBtn1Neveu = new javax.swing.JRadioButton();
        combo1Moloney = new javax.swing.JComboBox<>();
        cBox1Private = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        btnNext3 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        rBtn2Brady2s = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        rBtn2Brady4q = new javax.swing.JRadioButton();
        rBtn2Brady2q = new javax.swing.JRadioButton();
        rBtn2Osborns = new javax.swing.JRadioButton();
        rBtn2Villages = new javax.swing.JRadioButton();
        rBtn2Villageq = new javax.swing.JRadioButton();
        rBtn2Town = new javax.swing.JRadioButton();
        rBtn2Brady4s = new javax.swing.JRadioButton();
        rBtn2Osbornq = new javax.swing.JRadioButton();
        rBtn2Moloney = new javax.swing.JRadioButton();
        rBtn2Neveu = new javax.swing.JRadioButton();
        combo2Moloney = new javax.swing.JComboBox<>();
        cBox2Private = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lblFirstBuildingError = new javax.swing.JLabel();
        lblSecondBuildingError = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtRmFirstName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtRmLastName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtRmID = new javax.swing.JTextField();
        txtFirstNameError1 = new javax.swing.JLabel();
        txtLastNameError1 = new javax.swing.JLabel();
        txtIDError1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiMatch = new javax.swing.JMenuItem();
        jmiSave = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Roommate Matching");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        dropGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        dropGender.setSelectedIndex(1);
        dropGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropGenderActionPerformed(evt);
            }
        });

        txtID.setToolTipText("Don't include the \"A\"");

        lblGender.setText("Gender");

        lblID.setText("Student ID");

        lblFirstName.setText("First Name");

        btnNext1.setText("Next >>");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        lblFirstName1.setText("Last Name");

        jLabel24.setText("Graduation Year");

        ftxtGradYear.setText(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
        ftxtGradYear.setEnabled(false);

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtFirstNameError.setVisible(false);
        txtFirstNameError.setForeground(new java.awt.Color(255, 0, 0));
        txtFirstNameError.setText("Error Message");

        txtLastNameError.setVisible(false);
        txtLastNameError.setForeground(new java.awt.Color(255, 0, 0));
        txtLastNameError.setText("Error Message");

        txtIDError.setVisible(false);
        txtIDError.setForeground(new java.awt.Color(255, 0, 0));
        txtIDError.setText("Error Message");

        jScrollPane4.setVisible(false);

        jList2.setVisible(false);
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Student 1", "Student 2", "Student 3", "Student 4", "Student 5", "Student 6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

        jButton3.setVisible(false);
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setVisible(false);
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setVisible(false);
        jButton5.setText("Make 500 Students");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setVisible(false);
        jButton6.setText("just, DO IT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtSearchJList.setVisible(false);

        jLabel10.setVisible(false);
        jLabel10.setText("Search:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchJList))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGender)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblID)
                                    .addComponent(lblFirstName1)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNext1)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(dropGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ftxtGradYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))
                                            .addComponent(txtLastNameError)
                                            .addComponent(txtFirstNameError)
                                            .addComponent(txtIDError)))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 161, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(40, 40, 40)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblFirstName)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstNameError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastNameError)
                            .addComponent(lblFirstName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDError)
                            .addComponent(lblID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dropGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtGradYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(37, 37, 37)
                        .addComponent(btnNext1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchJList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(40, 40, 40))
        );

        jTabbedPane2.addTab("Basic Info", jPanel4);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Do you expect your room to be:");

        buttonGroup6.add(rBtnRoomStudy);
        rBtnRoomStudy.setText("a fairly private place to relax and study?");

        buttonGroup6.add(rBtnRoomSocial);
        rBtnRoomSocial.setText("a place where your friends come to socialize a bit?");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("How do you feel about your roommate having a significant other in your room?");

        buttonGroup8.add(rBtnSigOtherIDC);
        rBtnSigOtherIDC.setText("I don't care");

        buttonGroup8.add(rBtnSigOtherNo);
        rBtnSigOtherNo.setText("I would prefer not");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Do you smoke?");

        buttonGroup1.add(rBtnSmokeYes);
        rBtnSmokeYes.setText("Yes");

        buttonGroup1.add(rBtnSmokeNo);
        rBtnSmokeNo.setText("No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Do you object to a roommate who smokes?");

        buttonGroup2.add(rBtnRmSmokeYes);
        rBtnRmSmokeYes.setText("Yes");

        buttonGroup2.add(rBtnRmSmokeNo);
        rBtnRmSmokeNo.setText("No");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Do you prefer to go to bed:");

        buttonGroup4.add(rBtnBedTimeEarly);
        rBtnBedTimeEarly.setText("relatively early (generally before 10pm)?");

        buttonGroup4.add(rBtnBedTimeLate);
        rBtnBedTimeLate.setText("late (generally after 10pm)?");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Do you prefer to:");

        buttonGroup3.add(rBtnNotNeat);
        rBtnNotNeat.setText("not worry about how your room looks?");

        buttonGroup3.add(rBtnNeat);
        rBtnNeat.setText("keep your room neat?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("When you are studying, are you:");

        buttonGroup5.add(rBtnIgnoreNoise);
        rBtnIgnoreNoise.setText("able to ignore background noise?");

        buttonGroup5.add(rBtnQuietStudy);
        rBtnQuietStudy.setText("easily distracted, preferring relative quiet?");

        buttonGroup5.add(rBtnWantNoise);
        rBtnWantNoise.setText("able to ignore background noise and/or prefer background noise?");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("How do you feel about having your roommate use/borrow your things?");

        buttonGroup7.add(rBtnBorrowNever);
        rBtnBorrowNever.setText("My roommate should never use my things.");

        buttonGroup7.add(rBtnBorrowAsk);
        rBtnBorrowAsk.setText("It's okay as long as my roommate asks.");

        buttonGroup7.add(rBtnBorrowIDC);
        rBtnBorrowIDC.setText("I don't care.");

        btnNext2.setText("Next >>");
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        lblSmokeError.setVisible(false);
        lblSmokeError.setForeground(new java.awt.Color(255, 0, 0));
        lblSmokeError.setText("*Required");

        lblRmSmokeError.setVisible(false);
        lblRmSmokeError.setForeground(new java.awt.Color(255, 0, 0));
        lblRmSmokeError.setText("*Required");

        lblNeatError.setVisible(false);
        lblNeatError.setForeground(new java.awt.Color(255, 0, 0));
        lblNeatError.setText("*Required");

        lblBedtimeError.setVisible(false);
        lblBedtimeError.setForeground(new java.awt.Color(255, 0, 0));
        lblBedtimeError.setText("*Required");

        lblStudyingError.setVisible(false);
        lblStudyingError.setForeground(new java.awt.Color(255, 0, 0));
        lblStudyingError.setText("*Required");

        lblSocialError.setVisible(false);
        lblSocialError.setForeground(new java.awt.Color(255, 0, 0));
        lblSocialError.setText("*Required");

        lblBorrowError.setVisible(false);
        lblBorrowError.setForeground(new java.awt.Color(255, 0, 0));
        lblBorrowError.setText("*Required");

        lblSigOtherError.setVisible(false);
        lblSigOtherError.setForeground(new java.awt.Color(255, 0, 0));
        lblSigOtherError.setText("*Required");

        jPanel5.setPreferredSize(new java.awt.Dimension(338, 470));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("What do you enjoy doing in your spare time?");

        cBoxVideoGaming.setText("Video Gaming");

        cBoxInternetSurfing.setText("Internet Surfing");

        cBoxOutdoorActivities.setText("Outdoor Activities");

        cBoxTelevisionMovies.setText("Television/Movies");

        cBoxCrafting.setText("Crafting");

        cBoxHiking.setText("Hiking");

        cBoxPhotography.setText("Photography");

        cBoxExercising.setText("Exercising");

        cBoxSocializing.setText("Socializing");

        cBoxReading.setText("Reading");

        cBoxSports.setText("Sports");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Do you enjoy any sports?");

        cBoxVolleyball.setText("Volleyball");

        cBoxGolfing.setText("Golfing");

        cBoxDiving.setText("Diving");
        cBoxDiving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxDivingActionPerformed(evt);
            }
        });

        cBoxSwimming.setText("Swimming");

        cBoxTennis.setText("Tennis");

        cBoxFootball.setText("Football");

        cBoxBaseball.setText("Baseball");

        cBoxSoccer.setText("Soccer");

        cBoxBasketball.setText("Basketball");

        cBoxRollerblading.setText("Rollerblading");

        cBoxSnowboarding.setText("Snowboarding");

        cBoxFishing.setText("Fishing");

        cBoxBiking.setText("Biking");

        cBoxHunting.setText("Hunting");

        cBoxHockey.setText("Hockey");

        cBoxSkating.setText("Skating");

        cBoxKayaking.setText("Kayaking");

        cBoxRock.setText("Rock");

        cBoxPop.setText("Pop");

        cBoxCountry.setText("Country");

        cBoxClassical.setText("Classical");

        cBoxHipHop.setText("Hip-Hop");

        cBoxDance.setText("Dance");

        cBoxTechno.setText("Techno");

        cBoxMetal.setText("Metal");

        cBoxRap.setText("Rap");

        cBoxGospel.setText("Gospel");

        cBoxOther.setText("Other");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("What genres of music do you prefer?");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxVideoGaming)
                                    .addComponent(cBoxInternetSurfing)
                                    .addComponent(cBoxOutdoorActivities)
                                    .addComponent(cBoxTelevisionMovies))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxPhotography)
                                    .addComponent(cBoxSports)
                                    .addComponent(cBoxReading)
                                    .addComponent(cBoxSocializing)
                                    .addComponent(cBoxExercising)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxRollerblading)
                            .addComponent(cBoxFootball)
                            .addComponent(cBoxBaseball)
                            .addComponent(cBoxSoccer)
                            .addComponent(cBoxBasketball)
                            .addComponent(cBoxSnowboarding))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxVolleyball)
                                    .addComponent(cBoxTennis)
                                    .addComponent(cBoxSwimming)
                                    .addComponent(cBoxDiving)
                                    .addComponent(cBoxGolfing)
                                    .addComponent(cBoxHiking))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxSkating)
                                    .addComponent(cBoxFishing)
                                    .addComponent(cBoxBiking)
                                    .addComponent(cBoxHunting)
                                    .addComponent(cBoxHockey)
                                    .addComponent(cBoxKayaking)))
                            .addComponent(cBoxGospel)
                            .addComponent(cBoxRap)
                            .addComponent(cBoxMetal)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cBoxTechno)
                                .addGap(18, 18, 18)
                                .addComponent(txtOtherMusic))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cBoxDance)
                                .addGap(18, 18, 18)
                                .addComponent(cBoxOther))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxRock)
                            .addComponent(cBoxPop)
                            .addComponent(cBoxCountry)
                            .addComponent(cBoxClassical)
                            .addComponent(cBoxHipHop)
                            .addComponent(jLabel7)
                            .addComponent(cBoxCrafting)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cBoxVideoGaming)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxInternetSurfing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxOutdoorActivities)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxTelevisionMovies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxCrafting))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cBoxSports)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxReading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxSocializing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxExercising)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxPhotography)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cBoxTennis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxSwimming)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxDiving)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxGolfing, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxVolleyball)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxHiking))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cBoxFishing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxBiking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxHunting)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxHockey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxSkating)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBoxKayaking)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(cBoxFootball)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxBaseball)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxSoccer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxBasketball)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxRollerblading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxSnowboarding)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxRock)
                    .addComponent(cBoxDance)
                    .addComponent(cBoxOther))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxPop)
                    .addComponent(cBoxTechno)
                    .addComponent(txtOtherMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxCountry)
                    .addComponent(cBoxMetal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxClassical)
                    .addComponent(cBoxRap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBoxHipHop)
                    .addComponent(cBoxGospel))
                .addGap(103, 103, 103))
        );

        jScrollPane2.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStudyingError))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnSmokeYes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rBtnSmokeNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSmokeError))
                    .addComponent(rBtnRoomSocial)
                    .addComponent(rBtnRoomStudy)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSocialError))
                    .addComponent(rBtnIgnoreNoise)
                    .addComponent(rBtnBorrowNever)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBorrowError))
                    .addComponent(rBtnBorrowAsk)
                    .addComponent(rBtnBorrowIDC)
                    .addComponent(rBtnSigOtherIDC)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSigOtherError))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBtnSigOtherNo)
                        .addGap(159, 159, 159)
                        .addComponent(btnNext2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(rBtnNeat)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBedtimeError))
                            .addComponent(rBtnBedTimeLate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNeatError))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rBtnNotNeat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rBtnBedTimeEarly, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rBtnRmSmokeYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rBtnRmSmokeNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRmSmokeError))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rBtnQuietStudy)
                    .addComponent(rBtnWantNoise))
                .addGap(709, 709, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rBtnSmokeYes)
                    .addComponent(rBtnSmokeNo)
                    .addComponent(lblSmokeError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rBtnRmSmokeYes)
                    .addComponent(rBtnRmSmokeNo)
                    .addComponent(lblRmSmokeError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblNeatError))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBtnNeat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnNotNeat)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblBedtimeError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnBedTimeEarly)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnBedTimeLate))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblStudyingError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnQuietStudy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnIgnoreNoise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnWantNoise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSocialError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnRoomStudy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnRoomSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblBorrowError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnBorrowIDC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnBorrowAsk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtnBorrowNever)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblSigOtherError))
                .addGap(0, 0, 0)
                .addComponent(rBtnSigOtherIDC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtnSigOtherNo)
                    .addComponent(btnNext2))
                .addGap(137, 137, 137))
        );

        jTabbedPane2.addTab("Lifestyle Preferences", jPanel1);

        buttonGroup9.add(rBtn1Brady2s);
        rBtn1Brady2s.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Brady2s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1Brady2sActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Building");

        jLabel12.setText("Brady (two-man)");

        jLabel16.setText("Brady (four-man)");

        jLabel17.setText("Osborn Hall");

        jLabel18.setText("Student Village");

        buttonGroup9.add(rBtn1Brady4q);
        rBtn1Brady4q.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Brady4q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1Brady4qActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Brady2q);
        rBtn1Brady2q.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Brady2q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1Brady2qActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Osborns);
        rBtn1Osborns.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Osborns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1OsbornsActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Villages);
        rBtn1Villages.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Villages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1VillagesActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Villageq);
        rBtn1Villageq.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Villageq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1VillageqActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Town);
        rBtn1Town.setText("Townhouse");
        rBtn1Town.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Town.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1TownActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Brady4s);
        rBtn1Brady4s.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Brady4s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1Brady4sActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Osbornq);
        rBtn1Osbornq.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Osbornq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1OsbornqActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Moloney);
        rBtn1Moloney.setText("Moloney Apartments");
        rBtn1Moloney.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Moloney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1MoloneyActionPerformed(evt);
            }
        });

        buttonGroup9.add(rBtn1Neveu);
        rBtn1Neveu.setText("Neveu Apartments");
        rBtn1Neveu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn1Neveu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn1NeveuActionPerformed(evt);
            }
        });

        combo1Moloney.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One-Bedroom", "Two-Bedroom", "Three-Bedroom" }));
        combo1Moloney.setEnabled(false);

        cBox1Private.setText("Private Room Desired");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("FIRST CHOICE");

        btnNext3.setText("Next >>");
        btnNext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext3ActionPerformed(evt);
            }
        });

        jLabel49.setText("Standard");

        jLabel50.setText("    Quiet");

        buttonGroup10.add(rBtn2Brady2s);
        rBtn2Brady2s.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Brady2s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2Brady2sActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Building");

        jLabel52.setText("Brady (two-man)");

        jLabel53.setText("Brady (four-man)");

        jLabel54.setText("Osborn Hall");

        jLabel55.setText("Student Village");

        buttonGroup10.add(rBtn2Brady4q);
        rBtn2Brady4q.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Brady4q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2Brady4qActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Brady2q);
        rBtn2Brady2q.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Brady2q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2Brady2qActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Osborns);
        rBtn2Osborns.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Osborns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2OsbornsActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Villages);
        rBtn2Villages.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Villages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2VillagesActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Villageq);
        rBtn2Villageq.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Villageq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2VillageqActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Town);
        rBtn2Town.setText("Townhouse");
        rBtn2Town.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Town.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2TownActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Brady4s);
        rBtn2Brady4s.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Brady4s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2Brady4sActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Osbornq);
        rBtn2Osbornq.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Osbornq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2OsbornqActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Moloney);
        rBtn2Moloney.setText("Moloney Apartments");
        rBtn2Moloney.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Moloney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2MoloneyActionPerformed(evt);
            }
        });

        buttonGroup10.add(rBtn2Neveu);
        rBtn2Neveu.setText("Neveu Apartments");
        rBtn2Neveu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rBtn2Neveu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtn2NeveuActionPerformed(evt);
            }
        });

        combo2Moloney.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One-Bedroom", "Two-Bedroom", "Three-Bedroom" }));
        combo2Moloney.setEnabled(false);

        cBox2Private.setText("Private Room Desired");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("SECOND CHOICE");

        jLabel57.setText("Standard");

        jLabel58.setText("    Quiet");

        lblFirstBuildingError.setVisible(false);
        lblFirstBuildingError.setForeground(new java.awt.Color(255, 0, 0));
        lblFirstBuildingError.setText("*Required");

        lblSecondBuildingError.setVisible(false);
        lblSecondBuildingError.setForeground(new java.awt.Color(255, 0, 0));
        lblSecondBuildingError.setText("*Required");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblFirstBuildingError)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSecondBuildingError)
                    .addComponent(jLabel56))
                .addGap(148, 148, 148))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rBtn1Brady2s)
                    .addComponent(rBtn1Brady4s)
                    .addComponent(rBtn1Osborns)
                    .addComponent(rBtn1Villages)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rBtn1Villageq)
                        .addComponent(rBtn1Brady2q)
                        .addComponent(rBtn1Brady4q)
                        .addComponent(rBtn1Osbornq)))
                .addGap(108, 108, 108)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53)
                            .addComponent(jLabel55))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rBtn2Brady2s)
                    .addComponent(rBtn2Brady4s)
                    .addComponent(rBtn2Osborns)
                    .addComponent(rBtn2Villages)
                    .addComponent(jLabel57))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBtn2Villageq)
                            .addComponent(rBtn2Brady2q)
                            .addComponent(rBtn2Brady4q)
                            .addComponent(rBtn2Osbornq)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58)))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo1Moloney, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rBtn1Neveu)
                            .addComponent(cBox1Private)
                            .addComponent(rBtn1Moloney)
                            .addComponent(rBtn1Town))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBox2Private)
                            .addComponent(rBtn2Moloney)
                            .addComponent(rBtn2Town)
                            .addComponent(combo2Moloney, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rBtn2Neveu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btnNext3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel56))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel49)
                                .addComponent(jLabel50))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rBtn1Brady2q)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBtn1Brady4q)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(53, 53, 53)
                                            .addComponent(rBtn1Villageq))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(rBtn1Osbornq))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addComponent(rBtn1Villages))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rBtn1Brady2s)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBtn1Brady4s)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBtn1Osborns))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel11)
                            .addGap(25, 25, 25)
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel16)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel18))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFirstBuildingError)
                                .addComponent(lblSecondBuildingError))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel53)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel54)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(rBtn2Villageq))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rBtn2Brady2q)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBtn2Brady4q)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBtn2Osbornq))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(rBtn2Villages))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rBtn2Brady2s)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBtn2Brady4s)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBtn2Osborns))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtn1Town)
                    .addComponent(rBtn2Town))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtn1Moloney)
                    .addComponent(rBtn2Moloney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1Moloney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2Moloney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtn1Neveu)
                    .addComponent(rBtn2Neveu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBox1Private)
                    .addComponent(cBox2Private))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(btnNext3)
                .addGap(136, 136, 136))
        );

        jTabbedPane2.addTab("Housing Preferences", jPanel2);

        btnSubmit.setText("Submit Student");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel19.setText("This student would like to room with:");

        jLabel20.setText("First Name");

        jLabel21.setText("Last Name");

        jLabel22.setText("Student ID");

        txtFirstNameError1.setVisible(false);
        txtFirstNameError1.setForeground(new java.awt.Color(255, 0, 0));
        txtFirstNameError1.setText("Error Message");

        txtLastNameError1.setVisible(false);
        txtLastNameError1.setForeground(new java.awt.Color(255, 0, 0));
        txtLastNameError1.setText("Error Message");

        txtIDError1.setVisible(false);
        txtIDError1.setForeground(new java.awt.Color(255, 0, 0));
        txtIDError1.setText("Error Message");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRmFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRmLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRmID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstNameError1)
                            .addComponent(txtLastNameError1)
                            .addComponent(txtIDError1))))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel19)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtRmFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstNameError1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtRmLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastNameError1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtRmID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDError1))
                .addGap(81, 81, 81)
                .addComponent(btnSubmit)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Roommate Preferences", jPanel3);

        jMenu1.setText("File");

        jmiMatch.setText("Match!");
        jmiMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMatchActionPerformed(evt);
            }
        });
        jMenu1.add(jmiMatch);

        jmiSave.setText("Save");
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSave);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("Edit a Student");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //3===================== END ====================// 
    
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//edit menuItem - final
        if(!masterAll.isEmpty() )
        {//if there is something to even edit
            jTabbedPane2.setSelectedIndex(0);
            jScrollPane4.setVisible(true);
            jList2.setVisible(true);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
            txtSearchJList.setVisible(true);
            jLabel10.setVisible(true);
			txtSearchJList.setText("");
        }
        else
        {
            showMessageDialog(jTabbedPane2, "There are no students to edit!"); 
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
 
    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
//save feature - final
		if(!masterAll.isEmpty() )
		{
			try (PrintStream out = new PrintStream(
					new FileOutputStream("save.csv"))) 
			{
				Integer total = 0;
				Set<Map.Entry<String, Student> > allSet = masterAll.entrySet();
				for(Entry<String, Student> i : allSet)
				{
					total++;
					Student temp = (Student) i.getValue();
					if(total == masterAll.size() )
					{
						out.print(temp.getSaveOutput() );
					}
					else
					{
						out.println(temp.getSaveOutput() );
					}
				}
				out.close();
			} catch (FileNotFoundException ex) {
				Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("\ninside catch clause of save\n");
			}
		}
		else
		{
			showMessageDialog(jTabbedPane2, "There are no students to save!");
		}
    }//GEN-LAST:event_jmiSaveActionPerformed
//<editor-fold>
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
//submit a student - final

        if(validateFirstTab()
            && validateSecondTab()
            && validateThirdTab()
            && validateFourthTab() )
        {//store student into master hash
            //<editor-fold>
            Student newOne = new Student();
            //tab1 info
            newOne.setFirstName(txtFirstName.getText() );
            newOne.setLastName(txtLastName.getText() );
            newOne.setID(txtID.getText() );
            newOne.setGender(dropGender.getSelectedItem().toString() );
            newOne.setGradYear(Integer.parseInt(ftxtGradYear.getText() ) );
            //tab2 info
            newOne.setSmoker(rBtnSmokeYes.isSelected() );
            newOne.setRmSmoker(rBtnRmSmokeYes.isSelected() );
            newOne.setNeat(rBtnNeat.isSelected() );
            newOne.setEarlyBedTime(rBtnBedTimeEarly.isSelected() );
            if(rBtnQuietStudy.isSelected() )
            {
                newOne.setWhileStudying(1);
            }
            else if(rBtnIgnoreNoise.isSelected() )
            {
                newOne.setWhileStudying(2);
            }
            else
            {
                newOne.setWhileStudying(3);
            }
            newOne.setStudyInRoom(rBtnRoomStudy.isSelected() );
            if(rBtnBorrowIDC.isSelected() )
            {
                newOne.setBorrow(1);
            }
            else if(rBtnBorrowAsk.isSelected() )
            {
                newOne.setBorrow(2);
            }
            else
            {
                newOne.setBorrow(3);
            }
            newOne.setRoomMateSigOther(rBtnSigOtherIDC.isSelected() );

            if(cBoxBaseball.isSelected() ){ newOne.addToArrayList("Baseball"); }
            if(cBoxBasketball.isSelected() ){ newOne.addToArrayList("Basketball"); }
            if(cBoxBiking.isSelected() ){ newOne.addToArrayList("Biking"); }
            if(cBoxClassical.isSelected() ){ newOne.addToArrayList("Classical"); }
            if(cBoxCountry.isSelected() ){ newOne.addToArrayList("Country"); }
            if(cBoxCrafting.isSelected() ){ newOne.addToArrayList("Crafting"); }
            if(cBoxDance.isSelected() ){ newOne.addToArrayList("Dance"); }
            if(cBoxDiving.isSelected() ){ newOne.addToArrayList("Diving"); }
            if(cBoxExercising.isSelected() ){ newOne.addToArrayList("Exercising"); }
            if(cBoxFishing.isSelected() ){ newOne.addToArrayList("Fishing"); }
            if(cBoxFootball.isSelected() ){ newOne.addToArrayList("Football"); }
            if(cBoxGolfing.isSelected() ){ newOne.addToArrayList("Golfing"); }
            if(cBoxHiking.isSelected() ){ newOne.addToArrayList("Hiking"); }
            if(cBoxHipHop.isSelected() ){ newOne.addToArrayList("HipHop"); }
            if(cBoxHockey.isSelected() ) { newOne.addToArrayList("Hockey"); }
            if(cBoxHunting.isSelected() ) { newOne.addToArrayList("Hunting"); }
            if(cBoxInternetSurfing.isSelected() ){ newOne.addToArrayList("Internet Surfing"); }
            if(cBoxKayaking.isSelected() ){ newOne.addToArrayList("Kayaking"); }
            if(cBoxMetal.isSelected() ){ newOne.addToArrayList("Metal"); }
            if(cBoxOther.isSelected() ){ newOne.addToArrayList(txtOtherMusic.getText() ); }
            if(cBoxOutdoorActivities.isSelected() ){ newOne.addToArrayList("Outdoor Activities"); }
            if(cBoxPhotography.isSelected() ){ newOne.addToArrayList("Photography"); }
            if(cBoxPop.isSelected() ){ newOne.addToArrayList("Pop"); }
            if(cBoxRap.isSelected() ){ newOne.addToArrayList("Rap"); }
            if(cBoxReading.isSelected() ){ newOne.addToArrayList("Reading"); }
            if(cBoxRock.isSelected() ){ newOne.addToArrayList("Rock"); }
            if(cBoxRollerblading.isSelected() ){ newOne.addToArrayList("Rollerblading"); }
            if(cBoxSkating.isSelected() ){ newOne.addToArrayList("Skating"); }
            if(cBoxSnowboarding.isSelected() ){ newOne.addToArrayList("Snowboarding"); }
            if(cBoxSoccer.isSelected() ){ newOne.addToArrayList("Soccer"); }
            if(cBoxSocializing.isSelected() ){ newOne.addToArrayList("Socializing"); }
            if(cBoxSports.isSelected() ){ newOne.addToArrayList("Sports"); }
            if(cBoxSwimming.isSelected() ){ newOne.addToArrayList("Swimming"); }
            if(cBoxTechno.isSelected() ){ newOne.addToArrayList("Techno"); }
            if(cBoxTelevisionMovies.isSelected() ){ newOne.addToArrayList("Television/Movies"); }
            if(cBoxTennis.isSelected() ){ newOne.addToArrayList("Tennis"); }
            if(cBoxVideoGaming.isSelected() ){ newOne.addToArrayList("Video Gaming"); }
            if(cBoxVolleyball.isSelected() ){ newOne.addToArrayList("Volleyball"); }
            //tab3 info
            //<editor-fold>
            if(rBtn1Brady2s.isSelected() )
            {
                newOne.setFirstRoomPreference(1);
            }
            if(rBtn1Brady2q.isSelected() )
            {
                newOne.setFirstRoomPreference(2);
            }
            if(rBtn1Brady4s.isSelected() )
            {
                newOne.setFirstRoomPreference(3);
            }
            if(rBtn1Brady4q.isSelected() )
            {
                newOne.setFirstRoomPreference(4);
            }
            if(rBtn1Osborns.isSelected() )
            {
                newOne.setFirstRoomPreference(5);
            }
            if(rBtn1Osbornq.isSelected() )
            {
                newOne.setFirstRoomPreference(6);
            }
            if(rBtn1Villages.isSelected( ))
            {
                newOne.setFirstRoomPreference(7);
            }
            if(rBtn1Villageq.isSelected( ))
            {
                newOne.setFirstRoomPreference(8);
            }
            if(rBtn1Town.isSelected()  )
            {
                newOne.setFirstRoomPreference(14);
            }
            if(rBtn1Moloney.isSelected() )
            {
                switch (combo1Moloney.getSelectedItem().toString()) {
                    case "One-Bedroom":
                    newOne.setFirstRoomPreference(15);
                    break;
                    case "Two-Bedroom":
                    newOne.setFirstRoomPreference(16);
                    break;
                    case "Three-Bedroom":
                    newOne.setFirstRoomPreference(17);
                    break;
                    default:
                    break;
                }
            }
            if(rBtn1Neveu.isSelected() )
            {
                newOne.setFirstRoomPreference(18);
            }

            //second preference
            if(rBtn2Brady2s.isSelected() )
            {
                newOne.setSecondRoomPreference(1);
            }
            if(rBtn2Brady2q.isSelected() )
            {
                newOne.setSecondRoomPreference(2);
            }
            if(rBtn2Brady4s.isSelected() )
            {
                newOne.setSecondRoomPreference(3);
            }
            if(rBtn2Brady4q.isSelected() )
            {
                newOne.setSecondRoomPreference(4);
            }
            if(rBtn2Osborns.isSelected() )
            {
                newOne.setSecondRoomPreference(5);
            }
            if(rBtn2Osbornq.isSelected() )
            {
                newOne.setSecondRoomPreference(6);
            }
            if(rBtn2Villages.isSelected( ))
            {
                newOne.setSecondRoomPreference(7);
            }
            if(rBtn2Villageq.isSelected( ))
            {
                newOne.setSecondRoomPreference(8);
            }
            if(rBtn2Town.isSelected()  )
            {
                newOne.setSecondRoomPreference(14);
            }
            if(rBtn2Moloney.isSelected() )
            {
                switch (combo2Moloney.getSelectedItem().toString()) {
                    case "One-Bedroom":
                    newOne.setSecondRoomPreference(15);
                    break;
                    case "Two-Bedroom":
                    newOne.setSecondRoomPreference(16);
                    break;
                    case "Three-Bedroom":
                    newOne.setSecondRoomPreference(17);
                    break;
                    default:
                    break;
                }
            }
            if(rBtn2Neveu.isSelected() )
            {
                newOne.setSecondRoomPreference(18);
            }
            newOne.setFirstPrivateRoomDesired(cBox1Private.isSelected());
            newOne.setSecondPrivateRoomDesired(cBox2Private.isSelected());
            
            //tab4
            newOne.setWantToRoomWithFname(txtRmFirstName.getText() );
            newOne.setWantToRoomWithLname(txtRmLastName.getText() );
            newOne.setWantToRoomWithID(txtRmID.getText() );
            
            //</editor-fold>
            
            //</editor-fold>
            
            
            masterAll.put(newOne.getID(), newOne);
            //add to edit list
            listModel.addElement(newOne.getLastName() + ", " + newOne.getFirstName() + " - A" + newOne.getID());
            //sort edit list
            String[] myArr = new String[listModel.getSize() ];
            listModel.copyInto(myArr);
            Arrays.sort(myArr);
            listModel.clear();
            for(String i : myArr)
            {
                listModel.addElement(i);
            }
            //display sorted list
            jList2.setModel(listModel);

            //reset for another entry
            clearForm();
            jTabbedPane2.setSelectedIndex(0);
            btnSubmit.setText("Submit Student");
        }
        else
        {//pop up alerting user of errors
            String message = "There are errors on the following tabs:\n\n";

            if(!validateFirstTab() )
            {
                message += "Basic Info\n";
            }
            if(!validateSecondTab() )
            {
                message += "Lifestyle & Personal Preferences\n";
            }
            if (!validateThirdTab() )
            {
                message += "Housing Preferences\n";
            }
            if(!validateFourthTab() )
            {
                message = message + "Roommate Preferences\n";
            }
            message += "\n";
            showMessageDialog(btnSubmit, message);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void rBtn2NeveuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2NeveuActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2NeveuActionPerformed

    private void rBtn2MoloneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2MoloneyActionPerformed
        if(rBtn2Moloney.isSelected())
        {
            combo2Moloney.setEnabled(true);
        }
    }//GEN-LAST:event_rBtn2MoloneyActionPerformed

    private void rBtn2OsbornqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2OsbornqActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2OsbornqActionPerformed

    private void rBtn2Brady4sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2Brady4sActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2Brady4sActionPerformed

    private void rBtn2TownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2TownActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2TownActionPerformed

    private void rBtn2VillageqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2VillageqActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2VillageqActionPerformed

    private void rBtn2VillagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2VillagesActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2VillagesActionPerformed

    private void rBtn2OsbornsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2OsbornsActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2OsbornsActionPerformed

    private void rBtn2Brady2qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2Brady2qActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2Brady2qActionPerformed

    private void rBtn2Brady4qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2Brady4qActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2Brady4qActionPerformed

    private void rBtn2Brady2sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn2Brady2sActionPerformed
        combo2Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn2Brady2sActionPerformed

    private void btnNext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext3ActionPerformed
//button to validate page 3 info and change page
        if(validateThirdTab() )
        {
            String s = "";
            s = s + txtFirstName.getText();
            s = s + " " + txtLastName.getText();
            s = s + " would like to room with:";
            jLabel19.setText(s);
            jTabbedPane2.setSelectedIndex(3);
        }
    }//GEN-LAST:event_btnNext3ActionPerformed

    private void rBtn1NeveuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1NeveuActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1NeveuActionPerformed

    private void rBtn1MoloneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1MoloneyActionPerformed
        if(rBtn1Moloney.isSelected())
        {
            combo1Moloney.setEnabled(true);
        }
    }//GEN-LAST:event_rBtn1MoloneyActionPerformed

    private void rBtn1OsbornqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1OsbornqActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1OsbornqActionPerformed

    private void rBtn1Brady4sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1Brady4sActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1Brady4sActionPerformed

    private void rBtn1TownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1TownActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1TownActionPerformed

    private void rBtn1VillageqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1VillageqActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1VillageqActionPerformed

    private void rBtn1VillagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1VillagesActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1VillagesActionPerformed

    private void rBtn1OsbornsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1OsbornsActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1OsbornsActionPerformed

    private void rBtn1Brady2qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1Brady2qActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1Brady2qActionPerformed

    private void rBtn1Brady4qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1Brady4qActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1Brady4qActionPerformed

    private void rBtn1Brady2sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtn1Brady2sActionPerformed
        combo1Moloney.setEnabled(false);
    }//GEN-LAST:event_rBtn1Brady2sActionPerformed

    private void cBoxDivingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxDivingActionPerformed
        //IGNORE
    }//GEN-LAST:event_cBoxDivingActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
//button to validate page 2 info and change page

        if(validateSecondTab() )
        {
            jTabbedPane2.setSelectedIndex(2);
        }
    }//GEN-LAST:event_btnNext2ActionPerformed
//</editor-fold>
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//makes students with the exact same inputs for testing 
//not final

        rBtn2Brady2q.setSelected(true);
        rBtn1Brady2s.setSelected(true);
        rBtnSigOtherNo.setSelected(true);
        rBtnBorrowNever.setSelected(true);
        rBtnRoomStudy.setSelected(true);
        rBtnIgnoreNoise.setSelected(true);
        rBtnBedTimeEarly.setSelected(true);
        rBtnNeat.setSelected(true);
        rBtnRmSmokeYes.setSelected(true);
        rBtnSmokeYes.setSelected(true);
        cBoxVideoGaming.setSelected(true);
        cBoxOutdoorActivities.setSelected(true);
        cBoxInternetSurfing.setSelected(true);
        cBoxCrafting.setSelected(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//generate students - not final
        Integer[] roomChoice = new Integer[13];
        roomChoice[0] = 1;
        roomChoice[1] = 2;
        roomChoice[2] = 3;
        roomChoice[3] = 4;
        roomChoice[4] = 5;
        roomChoice[5] = 6;
        roomChoice[6] = 7;
        roomChoice[7] = 8;
        roomChoice[8] = 14;
        roomChoice[9] = 15;
        roomChoice[10] = 16;
        roomChoice[11] = 17;
        roomChoice[12] = 18;

        for(int i = 0; i < 100; i++)
        {
            Random ran = new Random();
            int fName = ran.nextInt(27);
            int lName = ran.nextInt(27);
            int id = ran.nextInt(100000000);
            int gradYear = ran.nextInt(5);
			
			//ran.nextInt(2) makes boys and girls
			//ran.nextInt(1) makes only boys
			//ran.nextInt(1) + 1 makes only girls
            int gender = ran.nextInt(2);
            
			
			int smoke = ran.nextInt(2);
            int rmSmoke = ran.nextInt(2);
            int neat = ran.nextInt(2);
            int bedTime = ran.nextInt(2);
            int study = ran.nextInt(3);
            int room = ran.nextInt(2);
            int borrow = ran.nextInt(3);
            int sigOther = ran.nextInt(2);

            //*
            //next 4 lines pick a room that is actually available
            int firstRoomIndex = ran.nextInt(13);
            int secondRoomIndex = ran.nextInt(13);
            int firstRoom = roomChoice[firstRoomIndex];
            int secondRoom = roomChoice[secondRoomIndex];
            //*/
            switch(fName)
            {
                case 0:  txtFirstName.setText("Q"); break;
                case 1:  txtFirstName.setText("W"); break;
                case 2:  txtFirstName.setText("E"); break;
                case 3:  txtFirstName.setText("R"); break;
                case 4:  txtFirstName.setText("T"); break;
                case 5:  txtFirstName.setText("Y"); break;
                case 6:  txtFirstName.setText("U"); break;
                case 7:  txtFirstName.setText("I"); break;
                case 8:  txtFirstName.setText("O"); break;
                case 9:  txtFirstName.setText("P"); break;
                case 10: txtFirstName.setText("A"); break;
                case 11: txtFirstName.setText("S"); break;
                case 12: txtFirstName.setText("D"); break;
                case 13: txtFirstName.setText("F"); break;
                case 14: txtFirstName.setText("G"); break;
                case 15: txtFirstName.setText("H"); break;
                case 16: txtFirstName.setText("J"); break;
                case 17: txtFirstName.setText("K"); break;
                case 18: txtFirstName.setText("L"); break;
                case 19: txtFirstName.setText("Z"); break;
                case 20: txtFirstName.setText("X"); break;
                case 21: txtFirstName.setText("C"); break;
                case 22: txtFirstName.setText("V"); break;
                case 23: txtFirstName.setText("B"); break;
                case 24: txtFirstName.setText("N"); break;
                default: txtFirstName.setText("M");
            }
            switch(lName)
            {
                case 0:  txtLastName.setText("Q"); break;
                case 1:  txtLastName.setText("W"); break;
                case 2:  txtLastName.setText("E"); break;
                case 3:  txtLastName.setText("R"); break;
                case 4:  txtLastName.setText("T"); break;
                case 5:  txtLastName.setText("Y"); break;
                case 6:  txtLastName.setText("U"); break;
                case 7:  txtLastName.setText("I"); break;
                case 8:  txtLastName.setText("O"); break;
                case 9:  txtLastName.setText("P"); break;
                case 10: txtLastName.setText("A"); break;
                case 11: txtLastName.setText("S"); break;
                case 12: txtLastName.setText("D"); break;
                case 13: txtLastName.setText("F"); break;
                case 14: txtLastName.setText("G"); break;
                case 15: txtLastName.setText("H"); break;
                case 16: txtLastName.setText("J"); break;
                case 17: txtLastName.setText("K"); break;
                case 18: txtLastName.setText("L"); break;
                case 19: txtLastName.setText("Z"); break;
                case 20: txtLastName.setText("X"); break;
                case 21: txtLastName.setText("C"); break;
                case 22: txtLastName.setText("V"); break;
                case 23: txtLastName.setText("B"); break;
                case 24: txtLastName.setText("N"); break;
                default: txtLastName.setText("M");
            }
            txtID.setText(String.format("%08d", id) );
            dropGender.setSelectedIndex(gender);
            ftxtGradYear.setText( String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - gradYear) );

            switch(smoke)
            {
                case 0:  rBtnSmokeYes.setSelected(true); break;
                case 1:  rBtnSmokeNo.setSelected(true); break;
            }
            switch(rmSmoke)
            {
                case 0:  rBtnRmSmokeYes.setSelected(true); break;
                case 1:  rBtnRmSmokeNo.setSelected(true); break;
            }
            switch(neat)
            {
                case 0:  rBtnNeat.setSelected(true); break;
                case 1:  rBtnNotNeat.setSelected(true); break;
            }
            switch(bedTime)
            {
                case 0:  rBtnBedTimeEarly.setSelected(true); break;
                case 1:  rBtnBedTimeLate.setSelected(true); break;
            }
            switch(study)
            {
                case 0:  rBtnIgnoreNoise.setSelected(true); break;
                case 1:  rBtnWantNoise.setSelected(true); break;
                case 2:  rBtnQuietStudy.setSelected(true); break;
            }
            switch(room)
            {
                case 0:  rBtnRoomStudy.setSelected(true); break;
                case 1:  rBtnRoomSocial.setSelected(true); break;
            }
            switch(borrow)
            {
                case 0:  rBtnBorrowNever.setSelected(true); break;
                case 1:  rBtnBorrowAsk.setSelected(true); break;
                case 2:  rBtnBorrowIDC.setSelected(true); break;
            }
            switch(sigOther)
            {
                case 0:  rBtnSigOtherNo.setSelected(true); break;
                case 1:  rBtnSigOtherIDC.setSelected(true); break;
            }

            switch(firstRoom)
            {
                case 1: rBtn1Brady2s.setSelected(true); break;
                case 2: rBtn1Brady2q.setSelected(true); break;
                case 3: rBtn1Brady4s.setSelected(true); break;
                case 4: rBtn1Brady4q.setSelected(true); break;
                case 5: rBtn1Osborns.setSelected(true); break;
                case 6: rBtn1Osbornq.setSelected(true); break;
                case 7: rBtn1Villages.setSelected(true); break;
                case 8: rBtn1Villageq.setSelected(true); break;
                case 14:rBtn1Town.setSelected(true); break;
                case 15:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(0);
                break;
                case 16:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(1);
                break;
                case 17:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(2);
                break;
                case 18:rBtn1Neveu.setSelected(true); break;
                default: rBtn1Villages.setSelected(true);
            }
            switch(secondRoom)
            {
                case 1: rBtn2Brady2s.setSelected(true); break;
                case 2: rBtn2Brady2q.setSelected(true); break;
                case 3: rBtn2Brady4s.setSelected(true); break;
                case 4: rBtn2Brady4q.setSelected(true); break;
                case 5: rBtn2Osborns.setSelected(true); break;
                case 6: rBtn2Osbornq.setSelected(true); break;
                case 7: rBtn2Villages.setSelected(true); break;
                case 8: rBtn2Villageq.setSelected(true); break;
                case 14:rBtn2Town.setSelected(true); break;
                case 15:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(0);
                break;
                case 16:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(1);
                break;
                case 17:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(2);
                break;
                case 18:rBtn2Neveu.setSelected(true); break;
                default: rBtn2Villages.setSelected(true);
            }

            btnSubmit.doClick();

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//delete student from list - final
        if(jList2.getSelectedIndex() > -1)
        {
            Integer index = jList2.getSelectedIndex();//index of selected item
            String curr = listModel.get(index).toString();//value of selected index

            String toRemove = curr.substring(curr.length() - 8 );//ID num of selected Student
            listModel.remove(index);//remove from list
            boysByGradYear.remove(masterAll.get(toRemove) );//remove from this arrayList
            girlsByGradYear.remove(masterAll.get(toRemove) );//remove from this arrayList
            masterAll.remove(toRemove);//remove from masterAll hash
        }
        if(masterAll.isEmpty() )
        {
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt){
                    jScrollPane4.setVisible(false);
                    jList2.setVisible(false);
                    jButton3.setVisible(false);
                    jButton4.setVisible(false);
                    txtSearchJList.setVisible(false);
                    jLabel10.setVisible(false);
                }
            };

            Timer t = new Timer(500, taskPerformer);
            t.setRepeats(false);
            t.start();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//update a student - final
        if(!masterAll.isEmpty() && jList2.getSelectedIndex() > -1)
        {
            txtSearchJList.setVisible(false);
            jLabel10.setVisible(false);

            clearForm();
            Student update = new Student();
            Integer index = jList2.getSelectedIndex();//index of selected item
            String curr = listModel.get(index).toString();//value of selected index
            String toUpdate = curr.substring(curr.length() - 8);//ID num of selected Student
            update = (Student) masterAll.get(toUpdate);//hold student obj
            //remove student to be edited
            listModel.remove(index);//remove from list
            boysByGradYear.remove(masterAll.get(toUpdate) );//remove from this arrayList
            girlsByGradYear.remove(masterAll.get(toUpdate) );//remove from this arrayList
            masterAll.remove(toUpdate);//remove from masterAll hash

            //TAB1
            txtFirstName.setText(update.getFirstName() );
            txtLastName.setText(update.getLastName() );
            txtID.setText(update.getID().toString() );
            if(update.getGender().equals("Male") )
            { dropGender.setSelectedIndex(0); }
            else if(update.getGender().equals("Female") )
            { dropGender.setSelectedIndex(1); }
            ftxtGradYear.setText(update.getGradYear().toString() );
            //TAB2
            if(update.getSmoker() )
            { rBtnSmokeYes.setSelected(true); }
            else
            { rBtnSmokeNo.setSelected(true); }
            if(update.getRmSmoker() )
            { rBtnRmSmokeYes.setSelected(true); }
            else
            { rBtnRmSmokeNo.setSelected(true); }
            if(update.getNeat() )
            { rBtnNeat.setSelected(true); }
            else
            { rBtnNotNeat.setSelected(true); }
            if(update.getEarlyBedTime() )
            { rBtnBedTimeEarly.setSelected(true); }
            else
            { rBtnBedTimeLate.setSelected(true); }

            switch(update.getWhileStudying() )
            {
                case 1:rBtnQuietStudy.setSelected(true);  break;
                case 2:rBtnIgnoreNoise.setSelected(true); break;
                case 3:rBtnWantNoise.setSelected(true);   break;
                default: break;
            }
            if(update.getStudyInRoom() )
            { rBtnRoomStudy.setSelected(true); }
            else
            { rBtnRoomSocial.setSelected(true); }
            switch(update.getBorrow() )
            {
                case 1:rBtnBorrowIDC.setSelected(true);   break;
                case 2:rBtnBorrowAsk.setSelected(true);   break;
                case 3:rBtnBorrowNever.setSelected(true); break;
                default: break;
            }
            if(update.getRoomMateSigOther() )
            { rBtnSigOtherIDC.setSelected(true); }
            else
            { rBtnSigOtherNo.setSelected(true);  }
            ArrayList<String> checkBoxes = new ArrayList<String>();
            checkBoxes = update.getSoftMatches();
            for(String temp : checkBoxes)
            {
                switch(temp)
                {
                    case "Baseball": cBoxBaseball.setSelected(true);break;
                    case "Basketball": cBoxBasketball.setSelected(true);break;
                    case "Biking": cBoxBiking.setSelected(true);break;
                    case "Classical": cBoxClassical.setSelected(true);break;
                    case "Country": cBoxCountry.setSelected(true);break;
                    case "Crafting": cBoxCrafting.setSelected(true);break;
                    case "Dance": cBoxDance.setSelected(true);break;
                    case "Diving": cBoxDiving.setSelected(true);break;
                    case "Exercising": cBoxExercising.setSelected(true);break;
                    case "Fishing": cBoxFishing.setSelected(true);break;
                    case "Football": cBoxFootball.setSelected(true);break;
                    case "Golfing": cBoxGolfing.setSelected(true);break;
                    case "Hiking": cBoxHiking.setSelected(true);break;
                    case "HipHop": cBoxHipHop.setSelected(true);break;
                    case "Hockey": cBoxHockey.setSelected(true);break;
                    case "Hunting": cBoxHunting.setSelected(true);break;
                    case "Internet Surfing": cBoxInternetSurfing.setSelected(true);break;
                    case "Kayaking": cBoxKayaking.setSelected(true);break;
                    case "Metal": cBoxMetal.setSelected(true);break;
                    case "Outdoor Activities": cBoxOutdoorActivities.setSelected(true);break;
                    case "Photography": cBoxPhotography.setSelected(true);break;
                    case "Pop": cBoxPop.setSelected(true);break;
                    case "Rap": cBoxRap.setSelected(true);break;
                    case "Reading": cBoxReading.setSelected(true);break;
                    case "Rock": cBoxRock.setSelected(true);break;
                    case "Rollerblading": cBoxRollerblading.setSelected(true);break;
                    case "Skating": cBoxSkating.setSelected(true);break;
                    case "Snowboarding": cBoxSnowboarding.setSelected(true);break;
                    case "Soccer": cBoxSoccer.setSelected(true);break;
                    case "Socializing": cBoxSocializing.setSelected(true);break;
                    case "Sports": cBoxSports.setSelected(true);break;
                    case "Swimming": cBoxSwimming.setSelected(true);break;
                    case "Techno": cBoxTechno.setSelected(true);break;
                    case "Television/Movies": cBoxTelevisionMovies.setSelected(true);break;
                    case "Tennis": cBoxTennis.setSelected(true);break;
                    case "Video Gaming": cBoxVideoGaming.setSelected(true);break;
                    case "Volleyball": cBoxVolleyball.setSelected(true);break;
                    default:cBoxOther.setSelected(true); txtOtherMusic.setText(temp);break;
                }//end checkBox switch
            }
            //TAB3
            switch(update.getFirstRoomPreference() )
            {
                case 1: rBtn1Brady2s.setSelected(true); break;
                case 2: rBtn1Brady2q.setSelected(true); break;
                case 3: rBtn1Brady4s.setSelected(true); break;
                case 4: rBtn1Brady4q.setSelected(true); break;
                case 5: rBtn1Osborns.setSelected(true); break;
                case 6: rBtn1Osbornq.setSelected(true); break;
                case 7: rBtn1Villages.setSelected(true); break;
                case 8: rBtn1Villageq.setSelected(true); break;
                case 14:rBtn1Town.setSelected(true); break;
                case 15:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(0);
                combo1Moloney.setEnabled(true);
                break;
                case 16:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(1);
                combo1Moloney.setEnabled(true);
                break;
                case 17:rBtn1Moloney.setSelected(true);
                combo1Moloney.setSelectedIndex(2);
                combo1Moloney.setEnabled(true);
                break;
                case 18:rBtn1Neveu.setSelected(true); break;
                default:break;
            }
            switch(update.getSecondRoomPreference() )
            {
                case 1: rBtn2Brady2s.setSelected(true); break;
                case 2: rBtn2Brady2q.setSelected(true); break;
                case 3: rBtn2Brady4s.setSelected(true); break;
                case 4: rBtn2Brady4q.setSelected(true); break;
                case 5: rBtn2Osborns.setSelected(true); break;
                case 6: rBtn2Osbornq.setSelected(true); break;
                case 7: rBtn2Villages.setSelected(true); break;
                case 8: rBtn2Villageq.setSelected(true); break;
                case 14:rBtn2Town.setSelected(true); break;
                case 15:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(0);
                combo2Moloney.setEnabled(true);
                break;
                case 16:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(1);
                combo2Moloney.setEnabled(true);
                break;
                case 17:rBtn2Moloney.setSelected(true);
                combo2Moloney.setSelectedIndex(2);
                combo2Moloney.setEnabled(true);
                break;
                case 18:rBtn2Neveu.setSelected(true); break;
                default:break;
            }
            if(update.getFirstPrivateRoomDesired() )
            { cBox1Private.setSelected(true); }
            if(update.getSecondPrivateRoomDesired() )
            { cBox2Private.setSelected(true); }
            //TAB4
            
            txtRmFirstName.setText(update.getWantToRoomWithFname() );
            txtRmLastName.setText(update.getWantToRoomWithLname() );
            txtRmID.setText(update.getWantToRoomWithID() );
            
            btnSubmit.setText("Update Student");

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//button to decrease students grad year - final
        Integer temp = Integer.parseInt(ftxtGradYear.getText());
        temp--;
        ftxtGradYear.setText(temp.toString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//button to increase students grad year - final
        Integer temp = Integer.parseInt(ftxtGradYear.getText());
        temp++;
        ftxtGradYear.setText(temp.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
//button to validate page 1 info and change page - final
        if(validateFirstTab())
        {
            jTabbedPane2.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void dropGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropGenderActionPerformed
        //IGNORE
    }//GEN-LAST:event_dropGenderActionPerformed

	//load menu item code
	//<editor-fold>
	/*
	
	//load feature - final - put into private member function
        try (BufferedReader reader = new BufferedReader(new FileReader("../save.csv") ) ) 
        {
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",", -1);
                Student newS = new Student();
                
                newS.setFirstName(data[0]);
                newS.setLastName(data[1]);
                newS.setID(data[2]);
                newS.setGradYear(Integer.parseInt(data[3]) );
                newS.setGender(data[4]);
                if(data[5].equals("1"))
                { newS.setSmoker(true); }
                else
                { newS.setSmoker(false); }
                if(data[6].equals("1"))
                { newS.setRmSmoker(true); }
                else
                { newS.setRmSmoker(false); }
                if(data[7].equals("1"))
                { newS.setEarlyBedTime(true); }
                else
                { newS.setEarlyBedTime(false); }
                if(data[8].equals("1"))
                { newS.setStudyInRoom(true); }
                else
                { newS.setStudyInRoom(false); }
                if(data[9].equals("1"))
                { newS.setRoomMateSigOther(true); }
                else
                { newS.setRoomMateSigOther(false); }
                if(data[10].equals("1"))
                { newS.setNeat(true); }
                else
                { newS.setNeat(false); }
                newS.setWhileStudying(Integer.parseInt(data[11]) );
                newS.setBorrow(Integer.parseInt(data[12]) );
                newS.setFirstRoomPreference(Integer.parseInt(data[13]) );
                newS.setSecondRoomPreference(Integer.parseInt(data[14]) );
                if(data[15].equals("1") )
                { newS.setFirstPrivateRoomDesired(true); }
                else
                { newS.setFirstPrivateRoomDesired(false); }
                if(data[16].equals("1") )
                { newS.setSecondPrivateRoomDesired(true); }
                else
                { newS.setSecondPrivateRoomDesired(false); }
                        
                if(data.length > 16)
                {//indecies of roommate info
                    newS.setWantToRoomWithFname(data[17]);
                    newS.setWantToRoomWithLname(data[18]);
                    newS.setWantToRoomWithID(data[19]);
                }
                if(data.length > 19)
                {//arrayList values
                    for(int i = 20; i < data.length; i++)
                    {
                        newS.addToArrayList(data[i]);
                    }
                }
                masterAll.put(newS.getID(), newS);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\ninside catch clause of load 1\n");
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\ninside catch clause of load 2\n");
        }
        
	
	*/
	//</editor-fold>
	
    private void jmiMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMatchActionPerformed
//match students, this is the magic
		clearEverything();
        if(!masterAll.isEmpty() )
        {//there are in fact students to match
            Set<Map.Entry<String, Student> > allSet = masterAll.entrySet();
            for(Entry<String, Student> i : allSet)
            {//put each student into the group they blong in
             //individual, or wantsRoommate
                Student curr = new Student();
                curr = (Student) i.getValue();
//                Boolean wantsRoommate = false;

                if(curr.getWantToRoomWithFname().equals("")
                    && curr.getWantToRoomWithLname().equals("")
                    && curr.getWantToRoomWithID().equals("") )
                {//this student has no roommate preference, add as normal
                    if(curr.getGender().equals("Male") )
                    {//student is male
                        addToBoysByGradYear(curr);
                    }
                    else if(curr.getGender().equals("Female") )
                    {//student is female
                        addToGirlsByGradYear(curr);
                    }
                }
                else
                {//student has a roommate preference
                    masterWantsRoommate.put(curr.getID(), curr);
                }
            }//end of for loop
            //match up those who want a certain roommate
            Set<Map.Entry<String, Student> > wantsRoommateSet1 = masterWantsRoommate.entrySet();
            Set<Map.Entry<String, Student> > wantsRoommateSet2 = masterWantsRoommate.entrySet();
            ArrayList<Roommates> preferredRoommates = new ArrayList<>();
            for(Entry<String, Student> j : wantsRoommateSet1)
            {
                Student curr1 = new Student();
                curr1 = (Student) j.getValue();
                Boolean foundRoommate = false;
                
                for(Entry<String, Student> k : wantsRoommateSet2)
                {
                    Student curr2 = new Student();
                    curr2 = (Student) k.getValue();
                    
                    if(curr1.getWantToRoomWithID().equals(curr2.getID() )
                        && curr2.getWantToRoomWithID().equals(curr1.getID() )
                        && !foundRoommate
                        && curr1.getGender().equals(curr2.getGender() ) )
                    {//curr1 wants to room w/ curr2
                     //AND curr2 wants to room w/curr1
                     //AND no roommate has been found
                     //AND they are of the same gender
                        Roommates room = new Roommates();
                        room.addFirst(curr1);
                        room.addSecond(curr2);
                        preferredRoommates.add(room);
                        foundRoommate = true;
                    }
                }
                if(!foundRoommate)
                {//curr1 did not have someone wanting to room with them
                 //add them back into gen. pop.
                    if(curr1.getGender().equals("Male") )
                    {//student is male
                        addToBoysByGradYear(curr1);
                    }
                    else if(curr1.getGender().equals("Female") )
                    {//student is female
                        addToGirlsByGradYear(curr1);
                    }
                }
            }//end of outer for-loop
            for(int i = 0; i < preferredRoommates.size(); i++)
            {//place all predetermined roommates into buildings
                findRoommatesBuilding(preferredRoommates.get(i) );
            }
			try {
				theMagic();
			} catch (FileNotFoundException ex) {
				Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
        }
        else
        {//there are no students
            showMessageDialog(jTabbedPane2, "There are no students to put into buildings!\n\n"); 
        }
    }//GEN-LAST:event_jmiMatchActionPerformed

    
    private void clearForm()
    {//resets the form
        //reset error labels
        txtFirstNameError.setVisible(false);
        txtLastNameError.setVisible(false);
        txtIDError.setVisible(false);
        lblSmokeError.setVisible(false);
        lblRmSmokeError.setVisible(false);
        lblNeatError.setVisible(false);
        lblBedtimeError.setVisible(false);
        lblStudyingError.setVisible(false);
        lblSocialError.setVisible(false);
        lblBorrowError.setVisible(false);
        lblSigOtherError.setVisible(false);
        lblFirstBuildingError.setVisible(false);
        lblSecondBuildingError.setVisible(false);
     
        //tab1
        txtFirstName.setText("");
        txtLastName.setText("");
        txtID.setText("");
        ftxtGradYear.setText(Integer.toString(Calendar.getInstance().get(Calendar.YEAR) ) );
        dropGender.setSelectedIndex(1);
        jScrollPane4.setVisible(false);
        jList2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        
        //tab2
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();
        buttonGroup5.clearSelection();
        buttonGroup6.clearSelection();
        buttonGroup7.clearSelection();
        buttonGroup8.clearSelection();
        //checkboxes
        cBoxBaseball.setSelected(false);
        cBoxBasketball.setSelected(false);
        cBoxBiking.setSelected(false);
        cBoxClassical.setSelected(false);
        cBoxCountry.setSelected(false);
        cBoxCrafting.setSelected(false);
        cBoxDance.setSelected(false);
        cBoxDiving.setSelected(false);
        cBoxExercising.setSelected(false);
        cBoxFishing.setSelected(false);
        cBoxFootball.setSelected(false);
        cBoxGolfing.setSelected(false);
        cBoxHiking.setSelected(false);
        cBoxHipHop.setSelected(false);
        cBoxHockey.setSelected(false);
        cBoxHunting.setSelected(false);
        cBoxInternetSurfing.setSelected(false);
        cBoxKayaking.setSelected(false);
        cBoxMetal.setSelected(false);
        cBoxOther.setSelected(false);
        cBoxOutdoorActivities.setSelected(false);
        cBoxPhotography.setSelected(false);
        cBoxPop.setSelected(false);
        cBoxRap.setSelected(false);
        cBoxReading.setSelected(false);
        cBoxRock.setSelected(false);
        cBoxRollerblading.setSelected(false);
        cBoxSkating.setSelected(false);
        cBoxSnowboarding.setSelected(false);
        cBoxSoccer.setSelected(false);
        cBoxSocializing.setSelected(false);
        cBoxSports.setSelected(false);
        cBoxSwimming.setSelected(false);
        cBoxTechno.setSelected(false);
        cBoxTelevisionMovies.setSelected(false);
        cBoxTennis.setSelected(false);
        cBoxVideoGaming.setSelected(false);
        cBoxVolleyball.setSelected(false);
        txtOtherMusic.setText("");
        jScrollPane2.getVerticalScrollBar().setValue(0);
        
        //tab3
        buttonGroup9.clearSelection();
        buttonGroup10.clearSelection();
        combo1Moloney.setSelectedIndex(0);
        combo1Moloney.setEnabled(false);
        combo2Moloney.setSelectedIndex(0);
        combo2Moloney.setEnabled(false);
        cBox1Private.setSelected(false);
        cBox2Private.setSelected(false);
        
        //tab4
        txtRmFirstName.setText("");
        txtRmLastName.setText("");
        txtRmID.setText("");
		jLabel10.setVisible(false);
		txtSearchJList.setVisible(false);
    }
    private boolean validateFirstTab()
    {
        String empty = "";
        
        //reset error labels
        txtFirstNameError.setVisible(false);
        txtLastNameError.setVisible(false);
        txtIDError.setVisible(false);
        Boolean validID = true;
        try{
            Integer ID = Integer.parseInt(txtID.getText());
        }catch(NumberFormatException e)
        {
            validID = false;
        }
        
                    
        if(!empty.equals(txtFirstName.getText())//firstName is NOT blank
           && !empty.equals(txtLastName.getText())//lastName is NOT blank
           && !empty.equals(txtID.getText())//ID is NOT blank
           && txtID.getText().length() == 8 //there are exactly 8 characters in string
           && !doesThisIDExist(txtID.getText() )//unused ID
           && validID ) //valid ID
        {
                txtFirstNameError.setVisible(false);
                txtLastNameError.setVisible(false);
                txtIDError.setVisible(false);
                return true;
        }
        else
        {
            if( empty.equals(txtFirstName.getText()) )
            {//firstName was left blank
                txtFirstNameError.setText("Requried Field");
                txtFirstNameError.setVisible(true);
            }
            if( empty.equals(txtLastName.getText()) )
            {//lastName was left blank
                txtLastNameError.setText("Required Field");
                txtLastNameError.setVisible(true);
            }
            if(!validID)
            {
                txtIDError.setText("Invalid ID");
                txtIDError.setVisible(true);
            }
            if( txtID.getText().length() < 8)
            {
                txtIDError.setText("ID is too short");
                txtIDError.setVisible(true);
            }
            if( empty.equals(txtID.getText()) )
            {//ID was left blank
                txtIDError.setText("Required Field"); 
                txtIDError.setVisible(true);
            }
            if( txtID.getText().length() > 8)
            {
                txtIDError.setText("ID is too long"); 
                txtIDError.setVisible(true);
            }
            if(doesThisIDExist(txtID.getText() ) )
            {//checks if id is already used
                txtIDError.setText("ID has been taken");
                txtIDError.setVisible(true);
            }
        }
        return false;
    }
    private boolean validateSecondTab()
    {
        lblSmokeError.setVisible(false);
        lblRmSmokeError.setVisible(false);
        lblNeatError.setVisible(false);
        lblBedtimeError.setVisible(false);
        lblStudyingError.setVisible(false);
        lblSocialError.setVisible(false);
        lblBorrowError.setVisible(false);
        lblSigOtherError.setVisible(false);
        
        if(   (rBtnSmokeYes.isSelected() || rBtnSmokeNo.isSelected() )
           && (rBtnRmSmokeYes.isSelected() || rBtnRmSmokeNo.isSelected() ) 
           && (rBtnNeat.isSelected() || rBtnNotNeat.isSelected() )
           && (rBtnBedTimeEarly.isSelected() || rBtnBedTimeLate.isSelected() )
           && (rBtnQuietStudy.isSelected() || rBtnWantNoise.isSelected() || rBtnIgnoreNoise.isSelected() )
           && (rBtnRoomStudy.isSelected() || rBtnRoomSocial.isSelected() )
           && (rBtnBorrowAsk.isSelected() || rBtnBorrowNever.isSelected() || rBtnBorrowIDC.isSelected() )
           && (rBtnSigOtherNo.isSelected() || rBtnSigOtherIDC.isSelected() ) )
        {//all required fields have been filled out
            return true;
        }
        else
        {//something wasnt filled out, find out which one(s)
            if(!(rBtnSmokeYes.isSelected() || rBtnSmokeNo.isSelected() ) )
            {
                lblSmokeError.setVisible(true);
            }
            if(!(rBtnRmSmokeYes.isSelected() || rBtnRmSmokeNo.isSelected() ) )
            {
                lblRmSmokeError.setVisible(true);
            }
            if(!(rBtnNeat.isSelected() || rBtnNotNeat.isSelected() ) )
            {
                lblNeatError.setVisible(true);
            }
            if(!(rBtnBedTimeEarly.isSelected() || rBtnBedTimeLate.isSelected() ) )
            {
                lblBedtimeError.setVisible(true);
            }
            if(!(rBtnQuietStudy.isSelected() || rBtnWantNoise.isSelected() || rBtnIgnoreNoise.isSelected() ) )
            {
                lblStudyingError.setVisible(true);
            }
            if(!(rBtnRoomStudy.isSelected() || rBtnRoomSocial.isSelected() ) )
            {
                lblSocialError.setVisible(true);
            }
            if(!(rBtnBorrowAsk.isSelected() || rBtnBorrowNever.isSelected() || rBtnBorrowIDC.isSelected() ) )
            {
                lblBorrowError.setVisible(true);
            }
            if(!(rBtnSigOtherNo.isSelected() || rBtnSigOtherIDC.isSelected() ) )
            {
                lblSigOtherError.setVisible(true);
            }
        }
        return false;
    }
    private boolean validateThirdTab()
    {
        lblFirstBuildingError.setVisible(false);
        lblSecondBuildingError.setVisible(false);
        
        if( (rBtn1Brady2s.isSelected()     || rBtn1Brady2q.isSelected() 
             || rBtn1Brady4s.isSelected()  || rBtn1Brady4q.isSelected() 
             || rBtn1Osborns.isSelected()  || rBtn1Osbornq.isSelected() 
             || rBtn1Villages.isSelected() || rBtn1Villageq.isSelected()
             || rBtn1Town.isSelected() 
             || rBtn1Moloney.isSelected()  || rBtn1Neveu.isSelected() )        
          &&   
            (rBtn2Brady2s.isSelected()     || rBtn2Brady2q.isSelected() 
             || rBtn2Brady4s.isSelected()  || rBtn2Brady4q.isSelected() 
             || rBtn2Osborns.isSelected()  || rBtn2Osbornq.isSelected() 
             || rBtn2Villages.isSelected() || rBtn2Villageq.isSelected()
             || rBtn2Town.isSelected() 
             || rBtn2Moloney.isSelected()  || rBtn2Neveu.isSelected() ) )
        {//one choice from each side has been selected
            return true;
        }
        else
        {
            if(!(rBtn1Brady2s.isSelected()     || rBtn1Brady2q.isSelected() 
             || rBtn1Brady4s.isSelected()  || rBtn1Brady4q.isSelected() 
             || rBtn1Osborns.isSelected()  || rBtn1Osbornq.isSelected() 
             || rBtn1Villages.isSelected() || rBtn1Villageq.isSelected()
             || rBtn1Town.isSelected() 
             || rBtn1Moloney.isSelected()  || rBtn1Neveu.isSelected() ) )
            {
                lblFirstBuildingError.setVisible(true);
            }
            if(!(rBtn2Brady2s.isSelected()     || rBtn2Brady2q.isSelected() 
             || rBtn2Brady4s.isSelected()  || rBtn2Brady4q.isSelected() 
             || rBtn2Osborns.isSelected()  || rBtn2Osbornq.isSelected() 
             || rBtn2Villages.isSelected() || rBtn2Villageq.isSelected()
             || rBtn2Town.isSelected() 
             || rBtn2Moloney.isSelected()  || rBtn2Neveu.isSelected() ) )
            {
                lblSecondBuildingError.setVisible(true);
            }
        }
        
        return false;
    }
    private boolean validateFourthTab()
    {
        String empty = "";
        
        //reset error labels
        txtFirstNameError1.setVisible(false);
        txtLastNameError1.setVisible(false);
        txtIDError1.setVisible(false);
        
        if(txtRmFirstName.getText().equals(empty)
           && txtRmLastName.getText().equals(empty)
           && txtRmID.getText().equals(empty) )
        {//all fields empty is valid
            return true;
        }
        else
        {
            Boolean validID = true;
            try{
                Integer ID = Integer.parseInt(txtID.getText());
            }catch(NumberFormatException e)
            {
                validID = false;
            }
            if(!txtRmFirstName.getText().equals(empty)
                && !txtRmLastName.getText().equals(empty)
                && !txtRmID.getText().equals(empty)
                && txtRmID.getText().length() == 8
                && validID)
            {
                return true;
            }
            else
            {
                if(txtRmFirstName.getText().equals(empty) )
                {
                    txtFirstNameError1.setText("Requried Field");
                    txtFirstNameError1.setVisible(true);
                }
                if(txtRmLastName.getText().equals(empty) )
                {
                    txtLastNameError1.setText("Requried Field");
                    txtLastNameError1.setVisible(true);
                }
                if(!validID)
                {
                    txtIDError1.setText("Invalid ID");
                    txtIDError1.setVisible(true);
                }
                if(txtRmID.getText().length() > 8)
                {
                    txtIDError1.setText("ID is too long");
                    txtIDError1.setVisible(true);
                }
                if(txtRmID.getText().length() < 8)
                {
                    txtIDError1.setText("ID is too short");
                    txtIDError1.setVisible(true);
                }
                if(txtRmID.getText().equals(empty) )
                {
                    txtIDError1.setText("Requried Field");
                    txtIDError1.setVisible(true);
                }
                return false;
            }
        }
    }
    private boolean doesThisIDExist(String id)
    {
        return (masterAll.containsKey(id) );
    }
    private void addToBoysByGradYear(Student next)
    {
        if(boysByGradYear.isEmpty())
        {
            boysByGradYear.add(next);
        }
        else
        {//loop through arraylist to find proper position for this student
            Student curr = new Student();
            for(Integer i = 0; i < boysByGradYear.size(); i++)
            {
                curr = boysByGradYear.get(i);//grab current student
                if(next.getGradYear() > curr.getGradYear() )
                {//sorts with "largest" grad year at index 0
                 //meaning the most recent HS grad
                    boysByGradYear.add(i, next);
                    return;//once added, we are done with this func
                }
                if(i == boysByGradYear.size() - 1)
                {
                    boysByGradYear.add(next);
                    return;//once added, we are done with this func
                }
            }
        }
    }
    private void addToGirlsByGradYear(Student next)
    {
        if(girlsByGradYear.isEmpty())
        {
            girlsByGradYear.add(next);
        }
        else
        {//loop through arraylist to find proper position for this student
            Student curr = new Student();
            for(Integer i = 0; i < girlsByGradYear.size(); i++)
            {
                curr = girlsByGradYear.get(i);//grab current student
                if(next.getGradYear() > curr.getGradYear() )
                {//sorts with "largest" grad year at index 0
                 //meaning the most recent HS grad
                    girlsByGradYear.add(i, next);
                    return;//once added, we are done with this func
                }
                if(i == girlsByGradYear.size() - 1)
                {
                    girlsByGradYear.add(next);
                    return;//once added, we are done with this func
                }
            }
        } 
    }
    private void findBuilding(Student student)
    {
        boolean firstAvailable  = false;
        boolean secondAvailable = false;
        boolean nowhere = true;
        Integer gyd = student.getGradYearDelta();
        //try first choice
        if(gyd == 0)
        {//all freshman stop here
            if(student.getGender().equals("Male") )
            {//freshman boys must live in brady if able
                firstAvailable = bradyHall.putInto(student);
				if(firstAvailable)
				{
					bradyCalls++;
				}
            }
            else
            {//female, try large side first
                firstAvailable = osbornHallLargeSide.putInto(student);
				if(firstAvailable)
				{
					osbornLargeCalls++;
				}
                if(!firstAvailable)
                {//large side didnt work, try small side
                    firstAvailable = osbornHallSmallSide.putInto(student);
					if(firstAvailable)
					{
						osbornSmallCalls++;
					}
                }
            }
            secondAvailable = firstAvailable;//if first placement worked, secondAvailable is now up to date for below
        }
        else
        {//student is not a freshman
            switch(student.getFirstRoomPreference() )
            {
                case 1:
                case 2:
                case 3:
                case 4:   //wanted some form of Brady hall
                    firstAvailable = bradyHall.putInto(student);
					if(firstAvailable)
					{
						bradyCalls++;
					}
                    break;
                case 5:  
                case 6:  //try osborn small side first
                    firstAvailable = osbornHallSmallSide.putInto(student);
					if(firstAvailable)
					{
						osbornSmallCalls++;
					}
                    if(!firstAvailable)
                    {//small side didnt work
                        firstAvailable = osbornHallLargeSide.putInto(student);
						if(firstAvailable)
						{
							osbornLargeCalls++;
						}
                    }
                    break;
                case 7:  //wanted village, try it
                case 8:  //firstAvailable will be false if it didnt work out for any reason
                    firstAvailable = studentVillage.putInto(student);
					if(firstAvailable)
					{
						villageCalls++;
					}
                    break;
                case 14: //wanted townhouse
                    firstAvailable = townhouses.putInto(student);
					if(firstAvailable)
					{
						townhouseCalls++;
					}
                    break;
                case 15: 
                case 16: 
                case 17: //wanted moloney apartments
                    firstAvailable = moloneyApartments.putInto(student);
					if(firstAvailable)
					{
						moloneyCalls++;
					}
                    break;
                case 18: //wanted neveu apartments
                    firstAvailable = neveuApartments.putInto(student);
					if(firstAvailable)
					{
						neveuCalls++;
					}
                    break;
                default: 
                    break;
            }
            if(!firstAvailable)
            {//first choice was not available
                switch(student.getSecondRoomPreference() )
                {//all non-freshman get placed in their second choice
                    case 1:
                    case 2:
                    case 3:
                    case 4:   //wanted some form of Brady hall
                        secondAvailable = bradyHall.putInto(student);
						if(secondAvailable)
						{
							bradyCalls++;
						}
                        break;
                    case 5:  
                    case 6:  //try osborn small side first
                        secondAvailable = osbornHallSmallSide.putInto(student);
						if(secondAvailable)
						{
							osbornSmallCalls++;
						}
						
                        if(!secondAvailable)
                        {//small side didnt work
                            secondAvailable = osbornHallLargeSide.putInto(student);
							if(secondAvailable)
							{
								osbornLargeCalls++;
							}
                        }
                        break;
                    case 7:  //wanted village, try it
                    case 8:  //firstAvailable will be false if it didnt work out for any reason
                        secondAvailable = studentVillage.putInto(student);
						if(secondAvailable)
						{
							villageCalls++;
						}
                        break;
                    case 14: //wanted townhouse
                        secondAvailable = townhouses.putInto(student);
						if(secondAvailable)
						{
							townhouseCalls++;
						}
                        break;
                    case 15: 
                    case 16: 
                    case 17: //wanted moloney apartments
                        secondAvailable = moloneyApartments.putInto(student);
						if(secondAvailable)
						{
							moloneyCalls++;
						}
                        break;
                    case 18: //wanted neveu apartments
                        secondAvailable = neveuApartments.putInto(student);
						if(secondAvailable)
						{
							neveuCalls++;
						}
                        break;
                    default: 
                        break;
                }
            }
        }//end of if(gyd == 0) else
        if(!firstAvailable && !secondAvailable)
        {//first AND second choice were unavailable
            nowhere = studentVillage.putInto(student);
			if(nowhere)
			{
				villageCalls++;
			}
        }
        if(!nowhere)
        {//no room in first or second choice, or the default (village)
            overflow.add(student);
			
        }
		totalCalls++;
    }  
    private void findRoommatesBuilding(Roommates r)
    {
        boolean firstAvailable  = false;
        boolean secondAvailable = false;
        boolean nowhere = true;
        Integer gyd = r.getGradYearDelta();
        //try first choice
        if(gyd == 0)
        {//all freshman stop here
            if(r.getGender().equals("Male") )
            {//freshman boys must live in brady if able
                firstAvailable = bradyHall.addRoommates(r);
            }
            else
            {//female, try large side first
                firstAvailable = osbornHallLargeSide.addRoommates(r);
                if(!firstAvailable)
                {//large side didnt work, try small side
                    firstAvailable = osbornHallSmallSide.addRoommates(r);
                }
            }
            secondAvailable = firstAvailable;//if first placement worked, secondAvailable is now up to date for below
        }//end of freshman
        else
        {
            switch(r.getFirstRoomPreference() )
            {//all non-freshman get placed
                case 1:
                case 2:
                case 3:
                case 4:   //wanted some form of Brady hall
                    firstAvailable = bradyHall.addRoommates(r);
                    break;
                case 5:  
                case 6:  //try osborn small side first
                    firstAvailable = osbornHallSmallSide.addRoommates(r);
                    if(!firstAvailable)
                    {//small side didnt work
                        firstAvailable = osbornHallLargeSide.addRoommates(r);
                    }
                    break;
                case 7:  //wanted village, try it
                case 8:  //firstAvailable will be false if it didnt work out for any reason
                    firstAvailable = studentVillage.addRoommates(r);
                    break;
                case 14: //wanted townhouse
                    firstAvailable = townhouses.addRoommates(r);
                    break;
                case 15: 
                case 16: 
                case 17: //wanted moloney apartments
                    firstAvailable = moloneyApartments.addRoommates(r);
                    break;
                case 18: //wanted neveu apartments
                    firstAvailable = neveuApartments.addRoommates(r);
                    break;
                default: 
                    break;
            }
            if(!firstAvailable)
            {//first choice was not available
                switch(r.getSecondRoomPreference() )
                {//all non-freshman get placed in their second choice
                    case 1:
                    case 2:
                    case 3:
                    case 4:   //wanted some form of Brady hall
                        secondAvailable = bradyHall.addRoommates(r);
                        break;
                    case 5:  
                    case 6:  //try osborn small side first
                        secondAvailable = osbornHallSmallSide.addRoommates(r);
                        if(!secondAvailable)
                        {//small side didnt work
                            secondAvailable = osbornHallLargeSide.addRoommates(r);
                        }
                        break;
                    case 7:  //wanted village, try it
                    case 8:  //firstAvailable will be false if it didnt work out for any reason
                        secondAvailable = studentVillage.addRoommates(r);
                        break;
                    case 14: //wanted townhouse
                        secondAvailable = townhouses.addRoommates(r);
                        break;
                    case 15: 
                    case 16: 
                    case 17: //wanted moloney apartments
                        secondAvailable = moloneyApartments.addRoommates(r);
                        break;
                    case 18: //wanted neveu apartments
                        secondAvailable = neveuApartments.addRoommates(r);
                        break;
                    default: 
                        break;
                }
            }
            //put into default
            if(!firstAvailable && !secondAvailable)
            {//first AND second choice were unavailable
                nowhere = studentVillage.addRoommates(r);
                if(!nowhere)
                {//no room in first or second choice, or the default (village)
                    wantsRoommateOverflow.add(r);
                }
            }
        }//end of else - NOT freshman block
    }
    private void load()
    {//load feature - final
        try (BufferedReader reader = new BufferedReader(new FileReader("save.csv") ) ) 
        {
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",", -1);
                Student newS = new Student();
                
                newS.setFirstName(data[0]);
                newS.setLastName(data[1]);
                newS.setID(data[2]);
                newS.setGradYear(Integer.parseInt(data[3]) );
                newS.setGender(data[4]);
                if(data[5].equals("1"))
                { newS.setSmoker(true); }
                else
                { newS.setSmoker(false); }
                if(data[6].equals("1"))
                { newS.setRmSmoker(true); }
                else
                { newS.setRmSmoker(false); }
                if(data[7].equals("1"))
                { newS.setEarlyBedTime(true); }
                else
                { newS.setEarlyBedTime(false); }
                if(data[8].equals("1"))
                { newS.setStudyInRoom(true); }
                else
                { newS.setStudyInRoom(false); }
                if(data[9].equals("1"))
                { newS.setRoomMateSigOther(true); }
                else
                { newS.setRoomMateSigOther(false); }
                if(data[10].equals("1"))
                { newS.setNeat(true); }
                else
                { newS.setNeat(false); }
                newS.setWhileStudying(Integer.parseInt(data[11]) );
                newS.setBorrow(Integer.parseInt(data[12]) );
                newS.setFirstRoomPreference(Integer.parseInt(data[13]) );
                newS.setSecondRoomPreference(Integer.parseInt(data[14]) );
                if(data[15].equals("1") )
                { newS.setFirstPrivateRoomDesired(true); }
                else
                { newS.setFirstPrivateRoomDesired(false); }
                if(data[16].equals("1") )
                { newS.setSecondPrivateRoomDesired(true); }
                else
                { newS.setSecondPrivateRoomDesired(false); }
                        
                if(data.length > 16)
                {//indecies of roommate info
                    newS.setWantToRoomWithFname(data[17]);
                    newS.setWantToRoomWithLname(data[18]);
                    newS.setWantToRoomWithID(data[19]);
                }
                if(data.length > 19)
                {//arrayList values
                    for(int i = 20; i < data.length; i++)
                    {
                        newS.addToArrayList(data[i]);
                    }
                }
                masterAll.put(newS.getID(), newS);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nFileNotFoundException\n");
        } catch (IOException ex) {
            //Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nIOException\n");
        }
        
        
    }
	private void theMagic() throws FileNotFoundException
	{//places all remaining students
	 //calls the proper functions for each building to match and output
		if(!masterAll.isEmpty() )
        {//as long as there are students to be matched

            Student currentBoy   = new Student();
            Student currentGirl  = new Student();
            Integer largestDelta = -1, largestBoyDelta = -1, largestGirlDelta = -1;
            
            try
            {
                largestBoyDelta = Calendar.getInstance().get(Calendar.YEAR) - boysByGradYear.get(boysByGradYear.size() - 1).getGradYear();
            }catch(Exception e)
            {
                largestBoyDelta = 0;
            }
            
            try
            {
                largestGirlDelta = Calendar.getInstance().get(Calendar.YEAR) - girlsByGradYear.get(girlsByGradYear.size() - 1).getGradYear();
            }catch(Exception e)
            {
                largestGirlDelta = 0;
            }
            
            if(masterAll.size() > 1)
            {
                if(largestBoyDelta > largestGirlDelta)
                { largestDelta = largestBoyDelta; }
                else
                { largestDelta = largestGirlDelta; }
            }
            else
            {//masterAll.size() == 1
                if(boysByGradYear.size() == 1)
                { largestDelta = largestBoyDelta; }
                else 
                { largestDelta = largestGirlDelta; }
            }
            for(int i = 0; i <= largestDelta; i++)
            {//this loop ensures recent grads will be assigned first
                ArrayList<Student>currentBoyGroup = new ArrayList<>();
                ArrayList<Student>currentGirlGroup = new ArrayList<>();
                for(int j = 0; j < boysByGradYear.size(); j++)
                {//get all BOYS of current grad year section
                    currentBoy = boysByGradYear.get(j);
                    if( currentBoy.getGradYearDelta() == i )
                    {//create a group of boys with the same gradYear
						currentBoyGroup.add(currentBoy);
                    }
                }
                for(int k = 0; k < currentBoyGroup.size(); k++)
                {//find all BOYS a building
					findBuilding(currentBoyGroup.get(k) );
                }
                //repeat for all girls
                for(int j = 0; j < girlsByGradYear.size(); j++)
                {//get all GIRLS of current grad year section
                    currentGirl = girlsByGradYear.get(j);
                    if(currentGirl.getGradYearDelta() == i )
                    {//create a group of boys with the same gradYear
						currentGirlGroup.add(currentGirl);
                    }
                }
                for(int k = 0; k < currentGirlGroup.size(); k++)
                {//find all GIRLS a building
                        findBuilding(currentGirlGroup.get(k) );
                }
            }
            
            
			
			
            
            
            osbornHallSmallSide.match();
            bradyHall.match();
			osbornHallLargeSide.match();
			studentVillage.match();
			moloneyApartments.match();
			neveuApartments.match();
			townhouses.match();
            
            System.out.println("total students: " + masterAll.size() );
            System.out.println("total OVERFLOW: " + overflow.size() );  
			
			
            System.out.println("totalCalls: " + totalCalls );  
            System.out.println("bradyCalls: " + bradyCalls );  
            System.out.println("osbornLargeCalls: " + osbornLargeCalls );  
            System.out.println("osbornSmallCalls: " + osbornSmallCalls );  
            System.out.println("villageCalls: " + villageCalls );  
            System.out.println("neveuCalls: " + neveuCalls );  
            System.out.println("townhouseCalls: " + townhouseCalls );  
            System.out.println("moloneyCalls: " + moloneyCalls );  
			
			if(!overflow.isEmpty() )
			{
				try (PrintStream out = new PrintStream(
						new FileOutputStream("overflowOut.csv"))) 
				{
					out.println("These are the student were unable to be placed");
					for(int i = 0; i < overflow.size(); i++)
					{
						if(i == overflow.size() - 1 )
						{
							out.print(overflow.get(i).getFinalOutput() );
						}
						else
						{
							out.println(overflow.get(i).getFinalOutput() );
						}
					}
					out.close();
				} catch (FileNotFoundException ex) {
					Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
					System.out.println("\ninside catch clause of townhouseOut\n");
				}
			}
        }
        else
        {
            showMessageDialog(jMenu1, "There are no students!\n\n");   
        }
	}
	private void clearEverything()
	{
		masterWantsRoommate.clear();
		overflow.clear();
		boysByGradYear.clear();
		girlsByGradYear.clear();
		wantsRoommateOverflow.clear();
		
			
		bradyHall.clear();
		osbornHallLargeSide.clear();
		osbornHallSmallSide.clear();
		studentVillage.clear();
		moloneyApartments.clear();
		neveuApartments.clear();
		townhouses.clear();
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame().setVisible(true);
        });
    }
//============ GENERATED VARIABLE DECLARATION ==============//
//<editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnNext3;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JCheckBox cBox1Private;
    private javax.swing.JCheckBox cBox2Private;
    private javax.swing.JCheckBox cBoxBaseball;
    private javax.swing.JCheckBox cBoxBasketball;
    private javax.swing.JCheckBox cBoxBiking;
    private javax.swing.JCheckBox cBoxClassical;
    private javax.swing.JCheckBox cBoxCountry;
    private javax.swing.JCheckBox cBoxCrafting;
    private javax.swing.JCheckBox cBoxDance;
    private javax.swing.JCheckBox cBoxDiving;
    private javax.swing.JCheckBox cBoxExercising;
    private javax.swing.JCheckBox cBoxFishing;
    private javax.swing.JCheckBox cBoxFootball;
    private javax.swing.JCheckBox cBoxGolfing;
    private javax.swing.JCheckBox cBoxGospel;
    private javax.swing.JCheckBox cBoxHiking;
    private javax.swing.JCheckBox cBoxHipHop;
    private javax.swing.JCheckBox cBoxHockey;
    private javax.swing.JCheckBox cBoxHunting;
    private javax.swing.JCheckBox cBoxInternetSurfing;
    private javax.swing.JCheckBox cBoxKayaking;
    private javax.swing.JCheckBox cBoxMetal;
    private javax.swing.JCheckBox cBoxOther;
    private javax.swing.JCheckBox cBoxOutdoorActivities;
    private javax.swing.JCheckBox cBoxPhotography;
    private javax.swing.JCheckBox cBoxPop;
    private javax.swing.JCheckBox cBoxRap;
    private javax.swing.JCheckBox cBoxReading;
    private javax.swing.JCheckBox cBoxRock;
    private javax.swing.JCheckBox cBoxRollerblading;
    private javax.swing.JCheckBox cBoxSkating;
    private javax.swing.JCheckBox cBoxSnowboarding;
    private javax.swing.JCheckBox cBoxSoccer;
    private javax.swing.JCheckBox cBoxSocializing;
    private javax.swing.JCheckBox cBoxSports;
    private javax.swing.JCheckBox cBoxSwimming;
    private javax.swing.JCheckBox cBoxTechno;
    private javax.swing.JCheckBox cBoxTelevisionMovies;
    private javax.swing.JCheckBox cBoxTennis;
    private javax.swing.JCheckBox cBoxVideoGaming;
    private javax.swing.JCheckBox cBoxVolleyball;
    private javax.swing.JComboBox<String> combo1Moloney;
    private javax.swing.JComboBox<String> combo2Moloney;
    private javax.swing.JComboBox<String> dropGender;
    private javax.swing.JFormattedTextField ftxtGradYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JMenuItem jmiMatch;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JLabel lblBedtimeError;
    private javax.swing.JLabel lblBorrowError;
    private javax.swing.JLabel lblFirstBuildingError;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFirstName1;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNeatError;
    private javax.swing.JLabel lblRmSmokeError;
    private javax.swing.JLabel lblSecondBuildingError;
    private javax.swing.JLabel lblSigOtherError;
    private javax.swing.JLabel lblSmokeError;
    private javax.swing.JLabel lblSocialError;
    private javax.swing.JLabel lblStudyingError;
    private javax.swing.JRadioButton rBtn1Brady2q;
    private javax.swing.JRadioButton rBtn1Brady2s;
    private javax.swing.JRadioButton rBtn1Brady4q;
    private javax.swing.JRadioButton rBtn1Brady4s;
    private javax.swing.JRadioButton rBtn1Moloney;
    private javax.swing.JRadioButton rBtn1Neveu;
    private javax.swing.JRadioButton rBtn1Osbornq;
    private javax.swing.JRadioButton rBtn1Osborns;
    private javax.swing.JRadioButton rBtn1Town;
    private javax.swing.JRadioButton rBtn1Villageq;
    private javax.swing.JRadioButton rBtn1Villages;
    private javax.swing.JRadioButton rBtn2Brady2q;
    private javax.swing.JRadioButton rBtn2Brady2s;
    private javax.swing.JRadioButton rBtn2Brady4q;
    private javax.swing.JRadioButton rBtn2Brady4s;
    private javax.swing.JRadioButton rBtn2Moloney;
    private javax.swing.JRadioButton rBtn2Neveu;
    private javax.swing.JRadioButton rBtn2Osbornq;
    private javax.swing.JRadioButton rBtn2Osborns;
    private javax.swing.JRadioButton rBtn2Town;
    private javax.swing.JRadioButton rBtn2Villageq;
    private javax.swing.JRadioButton rBtn2Villages;
    private javax.swing.JRadioButton rBtnBedTimeEarly;
    private javax.swing.JRadioButton rBtnBedTimeLate;
    private javax.swing.JRadioButton rBtnBorrowAsk;
    private javax.swing.JRadioButton rBtnBorrowIDC;
    private javax.swing.JRadioButton rBtnBorrowNever;
    private javax.swing.JRadioButton rBtnIgnoreNoise;
    private javax.swing.JRadioButton rBtnNeat;
    private javax.swing.JRadioButton rBtnNotNeat;
    private javax.swing.JRadioButton rBtnQuietStudy;
    private javax.swing.JRadioButton rBtnRmSmokeNo;
    private javax.swing.JRadioButton rBtnRmSmokeYes;
    private javax.swing.JRadioButton rBtnRoomSocial;
    private javax.swing.JRadioButton rBtnRoomStudy;
    private javax.swing.JRadioButton rBtnSigOtherIDC;
    private javax.swing.JRadioButton rBtnSigOtherNo;
    private javax.swing.JRadioButton rBtnSmokeNo;
    private javax.swing.JRadioButton rBtnSmokeYes;
    private javax.swing.JRadioButton rBtnWantNoise;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JLabel txtFirstNameError;
    private javax.swing.JLabel txtFirstNameError1;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtIDError;
    private javax.swing.JLabel txtIDError1;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JLabel txtLastNameError;
    private javax.swing.JLabel txtLastNameError1;
    private javax.swing.JTextField txtOtherMusic;
    private javax.swing.JTextField txtRmFirstName;
    private javax.swing.JTextField txtRmID;
    private javax.swing.JTextField txtRmLastName;
    private javax.swing.JTextField txtSearchJList;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
