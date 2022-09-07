package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import db.util.DBConnManager;
import model.dao.BookDAO;
import model.dao.MemberDAO;
import model.vo.Book;
import model.vo.Member;
import view.admin.AdminView;
import view.book.BookGenreView;
import view.book.BookPayView;
import view.book.BookSelectView;
import view.history.HistoryView;
import view.member.CashView;
import view.member.JoinView;
import view.member.LoginView;
import view.member.MyPageView;
import view.member.PwdUpdateView;

public class Controller implements ActionListener {
    LoginView viewLogin;
    JoinView viewJoin;
    PwdUpdateView viewPwdUpdate;
    BookGenreView viewBookGenre;
    BookSelectView viewBookSelect;
    BookPayView viewBookPay;
    MyPageView viewMyPage;
    HistoryView viewHistory;
    CashView viewCash;
    AdminView viewAdmin;

    String[] grade = { "VVIP", "VIP", "일반" };
    int selectedBook;
    String userId;
    boolean adminFlage = false;

    ArrayList<Book> list;

    public Controller() {
        viewLogin = new LoginView();
        viewJoin = new JoinView();
        viewPwdUpdate = new PwdUpdateView();
        viewBookGenre = new BookGenreView();
        viewBookSelect = new BookSelectView();
        viewMyPage = new MyPageView();
        viewHistory = new HistoryView();
        viewCash = new CashView();
        viewAdmin = new AdminView();
        viewBookPay = new BookPayView();
        list = new ArrayList<>();
        eventup();
    }

    public void eventup() {
        viewLogin.btnJoin.addActionListener(this);
        viewJoin.btnSubmit.addActionListener(this);
        viewBookGenre.btnSelect.addActionListener(this);
        viewBookSelect.btnLogout.addActionListener(this);
        viewBookSelect.btnGenre.addActionListener(this);
        viewBookSelect.btnSelect.addActionListener(this);
        viewLogin.btnLogin.addActionListener(this);
        viewJoin.btnReset.addActionListener(this);
        viewBookSelect.btnMyPage.addActionListener(this);
        viewMyPage.btnBack.addActionListener(this);
        viewMyPage.btnLogout.addActionListener(this);
        viewMyPage.btnUpdate.addActionListener(this);
        viewPwdUpdate.btnReset.addActionListener(this);
        viewPwdUpdate.btnSubmit.addActionListener(this);
        viewMyPage.btnHistory.addActionListener(this);
        viewHistory.btnBack.addActionListener(this);
        viewMyPage.btnCash.addActionListener(this);
        viewCash.btnBack.addActionListener(this);
        viewCash.btnSubmit.addActionListener(this);
        viewAdmin.btnSelectAllMember.addActionListener(this);
        viewAdmin.btnSelectMember.addActionListener(this);
        viewAdmin.btnBack.addActionListener(this);
        viewAdmin.btnSelectAllBook.addActionListener(this);
        viewAdmin.btnSelectBook.addActionListener(this);
        viewAdmin.btnAddQuiz.addActionListener(this);
        viewAdmin.btnAddBook.addActionListener(this);


        viewBookPay.btnPay.addActionListener(this);
        viewBookPay.btnBack.addActionListener(this);

        for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
            viewBookSelect.viewBookClick[i].tglBtnImage.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    boolean flag = false; // toggle button이 선택되었는지 여부를 확인하는 변수
                    for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
                        viewBookSelect.viewBookClick[i].taContent.setVisible(false);
                    }
                    /*--------------------toggle button 체크 확인------------------*/
                    for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
                        if (viewBookSelect.viewBookClick[i].tglBtnImage.isSelected()) {
                            flag = true;
                            selectedBook = i;
                            viewBookSelect.viewBookClick[i].taContent.setVisible(true);
                        }
                    }

                    /*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
                    if (!flag) {
                        for (int j = 0; j < viewBookSelect.viewBookClick.length; j++) {
                            viewBookSelect.viewBookClick[j].tglBtnImage.setEnabled(true);
                        }
                    } else {
                        for (int j = 0; j < viewBookSelect.viewBookClick.length; j++)
                            if (selectedBook != j) {
                                viewBookSelect.viewBookClick[j].tglBtnImage.setEnabled(false);
                            }
                    }
                    System.out.println("selected_book : " + selectedBook);
                }// mouseReleased
            });// v_schedule.v_sd[i].addMouseListener
        } // for
    }

    public void setClickBookText(int i, boolean flag) {
        viewBookSelect.viewBookClick[i].labelName.setVisible(flag);
        viewBookSelect.viewBookClick[i].labelWriter.setVisible(flag);
        viewBookSelect.viewBookClick[i].labelPrice.setVisible(flag);
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob == viewLogin.btnJoin) {// 회원가입 폼 열기
            viewJoin.tfId.setText("");
            viewJoin.tfName.setText("");
            viewJoin.tfPwd.setText("");
            viewJoin.tfPwd2.setText("");
            viewJoin.tfEmail.setText("");
            viewJoin.tfId.requestFocus();
            viewLogin.setVisible(false);
            viewJoin.setVisible(true);
        } else if (ob == viewJoin.btnSubmit) { // 회원가입하기
            Member m = new Member();
            m.setId(viewJoin.tfId.getText());
            m.setPass(new String(viewJoin.tfPwd.getPassword()));
            m.setEname(viewJoin.tfName.getText());
            m.setEmail(viewJoin.tfEmail.getText());
            m.setGenre(viewJoin.cbGenre.getSelectedItem().toString());
            if (new MemberDAO().insertJoin(m)) {
                viewJoin.showMsg("환영합니다^^");
                viewJoin.setVisible(false);
                viewLogin.setVisible(true);
            } else {
                viewJoin.showMsg("가입할 수 없습니다!");
            }
        } else if (ob == viewBookGenre.btnSelect) {
            String genre;
            if(viewBookGenre.rBtnFiction.isSelected()) {
                genre = viewBookGenre.rBtnFiction.getText();
            }else if(viewBookGenre.rBtnAssay.isSelected()) {
                genre = viewBookGenre.rBtnAssay.getText();
            }else {
                genre = viewBookGenre.rb_3.getText();             
            }
            new MemberDAO().updateGenre(userId, genre);

            viewBookGenre.setVisible(false);
            viewBookSelect.setVisible(true);
        } else if (ob == viewBookSelect.btnLogout) {
            viewBookSelect.setVisible(false);
            viewLogin.setVisible(true);
        } else if (ob == viewBookSelect.btnGenre) {
            viewBookSelect.setVisible(false);
            viewBookGenre.setVisible(true);
        } else if (ob == viewLogin.btnLogin) {// 로그인창 시작.
            String id = viewLogin.tfId.getText();
            String pass = new String(viewLogin.tfPwd.getPassword());
            if (id.equals("admin") && pass.equals("manager")) {// 1-1 관리자 로그인
                viewLogin.showMsg("관리자 로그인 성공!!");
                viewLogin.setVisible(false);
                viewAdmin.setVisible(true);
                return;
            }

            if ((new MemberDAO().loginCheck(id, pass))) { // 1.로그인 성공!
                viewLogin.showMsg(id + "님 환영합니다 ^_^");
                userId = id;
                viewBookSelect.labelId.setText(userId + "님");
                /*
                 * list = new BookDAO().recommendBook(new MemberDAO().selectGenre(id));
                 * 
                 * Random random = new Random(); for(int i=0; i<3 ;i++) { // 랜덤한 함수 필요 !! int
                 * ranNum = random.nextInt(list.size())+1; Book book = list.get(ranNum);
                 * 
                 * v_bookselect.v_bc[i].la_name.setText(book.getBname()); }
                 */
                viewLogin.setVisible(false);
                viewBookSelect.setVisible(true); // v_bookselect 로 이동
            } else {
                viewLogin.showMsg("아이디 또는 비밀번호를 확인해주세요!");
                viewLogin.tfId.setText("");
                viewLogin.tfId.requestFocus();
                viewLogin.tfPwd.setText("");
            }
        }else if(ob== viewJoin.btnCheckId) {
            String id = viewJoin.tfId.getText();
            if(new MemberDAO().dupliCheck(id)) {
                viewJoin.showMsg("중복된 아이디가 존재합니다.");
                viewJoin.tfId.setText("");
                viewJoin.tfId.requestFocus();
            }
        }else if (ob == viewJoin.btnReset) {
            viewJoin.setVisible(false);
            viewLogin.setVisible(true);
        } else if (ob == viewBookSelect.btnMyPage) {// 마이페이지로 이동
            viewMyPage.labelMsg.setText(userId + "님 환영합니다.");

            Member m = new MemberDAO().selectMypage(userId);
            viewMyPage.labelGrade.setText("등급: " + grade[m.getGrade() - 1]);
            viewMyPage.labelCash.setText("캐시: " + m.getCash() + "원");
            viewMyPage.labelPoint.setText("잔여포인트: " + m.getPoint() + "P");

            viewBookSelect.setVisible(false);
            viewMyPage.setVisible(true);
        }else if(ob==viewBookSelect.btnSelect){


            Member m = new MemberDAO().selectMypage("회원 ID: " +userId);
            viewBookPay.labelId.setText(m.getId());
            viewBookPay.labelGrade.setText("회원 등급: "+grade[m.getGrade()-1]);
            viewBookPay.labelPoint.setText("회원 포인트: "+m.getPoint()+"P");


            viewBookSelect.setVisible(false);
            viewBookPay.setVisible(true);
        }else if (ob == viewMyPage.btnBack) {
            viewMyPage.setVisible(false);
            viewBookSelect.setVisible(true);
        } else if (ob == viewMyPage.btnLogout) {
            viewMyPage.setVisible(false);
            viewLogin.setVisible(true);
        } else if (ob == viewMyPage.btnUpdate) {
            Member m = new MemberDAO().selectMemberInfo(userId);
            viewPwdUpdate.tfId.setText(m.getId());
            viewPwdUpdate.tfName.setText(m.getEname());
            viewPwdUpdate.tfEmail.setText(m.getEmail());
            viewPwdUpdate.tfPwd.setText("");
            viewPwdUpdate.tfPwd2.setText("");
            viewPwdUpdate.tfPwd.requestFocus();
            viewMyPage.setVisible(false);
            viewPwdUpdate.setVisible(true);
        } else if (ob == viewPwdUpdate.btnReset) {
            viewPwdUpdate.setVisible(false);
            viewMyPage.setVisible(true);
        } else if (ob == viewPwdUpdate.btnSubmit) {
            String pass = new String(viewPwdUpdate.tfPwd.getPassword());
            if (new MemberDAO().loginCheck(userId, pass)) {
                viewPwdUpdate.showMsg("현재와 다른 비밀번호로 변경해주세요!");
                viewPwdUpdate.tfPwd.setText("");
                viewPwdUpdate.tfPwd2.setText("");
                viewPwdUpdate.tfPwd.requestFocus();
                return;
            }
            if (new MemberDAO().updateMemberInfo(userId, pass)) {
                // 비밀번호 변경이 성공한다면
                viewPwdUpdate.showMsg("비밀번호를 변경하였습니다!");
            } else {
                viewPwdUpdate.showMsg("비밀번호 변경을 실패하였습니다!");
            }

            viewPwdUpdate.setVisible(false);
            viewMyPage.setVisible(true);
        } else if (ob == viewMyPage.btnHistory) {

            viewMyPage.setVisible(false);
            viewHistory.setVisible(true);
        } else if (ob == viewHistory.btnBack) {
            viewHistory.setVisible(false);
            viewMyPage.setVisible(true);
        } else if (ob == viewMyPage.btnCash) {
            Member m = new MemberDAO().selectMypage(userId);
            viewCash.la_nowcash.setText("현재 캐시: " + m.getCash()+"원");
            viewCash.tf_cash.setText("");
            viewCash.tf_cash.requestFocus();
            viewMyPage.setVisible(false);
            viewCash.setVisible(true);
        } else if (ob == viewCash.btnBack) {
            viewCash.setVisible(false);
            viewMyPage.setVisible(true);
        } else if(ob == viewCash.btnSubmit) {
            String cashCharge = viewCash.tf_cash.getText();
            if(cashCharge.matches("[\\d]+")) {
                if(new MemberDAO().updateCashCharge(userId, Integer.parseInt(cashCharge))) {
                    viewCash.showMsg(cashCharge+" 원 충전이 완료되었습니다!");
                    viewCash.tf_cash.setText("");
                    viewCash.setVisible(false);
                    viewMyPage.setVisible(true);
                }
            }else { 
                viewCash.showMsg("숫자만 입력가능합니다!");
            }
        } else if(ob==viewAdmin.btnBack) {
            viewAdmin.setVisible(false);
            viewLogin.setVisible(true);
        } else if(ob == viewAdmin.btnSelectAllMember) {
            ArrayList<Member> list = new MemberDAO().selectAllMember();
            viewAdmin.displayTable(list);

        } else if(ob == viewAdmin.btnSelectMember) {
            String id = viewAdmin.showInputMsg("조회할 회원의 아이디를 입력하세요");
            ArrayList<Member> list = new MemberDAO().selectMember(id);
            viewAdmin.displayTable(list);
        }else if(ob == viewAdmin.btnAddQuiz) {

        }else if(ob == viewAdmin.btnAddBook) {

        }else if(ob == viewAdmin.btnSelectAllBook) {

        }else if(ob == viewAdmin.btnSelectBook) {

        }else if(ob == viewBookPay.btnPay) {

        }else if(ob == viewBookPay.btnBack) {

        }

    }
}
