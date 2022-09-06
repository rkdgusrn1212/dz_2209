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
import view.AdminView;
import view.BookGenreView;
import view.BookPayView;
import view.BookSelectView;
import view.CashView;
import view.HistoryView;
import view.JoinView;
import view.LoginView;
import view.MyPageView;
import view.PassUpdateView;

public class Controller implements ActionListener {
    LoginView v_login;
    JoinView v_join;
    PassUpdateView v_passup;
    BookGenreView v_bookgenre;
    BookSelectView v_bookselect;
    BookPayView v_bookpay;
    MyPageView v_mypage;
    HistoryView v_history;
    CashView v_cash;
    AdminView v_admin;

    String[] grade = { "VVIP", "VIP", "일반" };
    int selected_book;
    String userid;
    boolean adminflage = false;

    ArrayList<Book> list;

    public Controller() {
        v_login = new LoginView();
        v_join = new JoinView();
        v_passup = new PassUpdateView();
        v_bookgenre = new BookGenreView();
        v_bookselect = new BookSelectView();
        v_mypage = new MyPageView();
        v_history = new HistoryView();
        v_cash = new CashView();
        v_admin = new AdminView();
        v_bookpay = new BookPayView();
        list = new ArrayList<>();
        eventup();
    }

    public void eventup() {
        v_login.bt_join.addActionListener(this);
        v_join.bt_submit.addActionListener(this);
        v_bookgenre.bt_select.addActionListener(this);
        v_bookselect.bt_logout.addActionListener(this);
        v_bookselect.bt_genre.addActionListener(this);
        v_bookselect.bt_select.addActionListener(this);
        v_login.bt_login.addActionListener(this);
        v_join.bt_reset.addActionListener(this);
        v_bookselect.bt_mypage.addActionListener(this);
        v_mypage.bt_back.addActionListener(this);
        v_mypage.bt_logout.addActionListener(this);
        v_mypage.bt_update.addActionListener(this);
        v_passup.bt_reset.addActionListener(this);
        v_passup.bt_submit.addActionListener(this);
        v_mypage.bt_history.addActionListener(this);
        v_history.bt_back.addActionListener(this);
        v_mypage.bt_cash.addActionListener(this);
        v_cash.bt_back.addActionListener(this);
        v_cash.bt_submit.addActionListener(this);
        v_admin.bt_selectallmember.addActionListener(this);
        v_admin.bt_selectmember.addActionListener(this);
        v_admin.bt_back.addActionListener(this);
        v_admin.bt_selectallbook.addActionListener(this);
        v_admin.bt_selectbook.addActionListener(this);
        v_admin.bt_addquiz.addActionListener(this);
        v_admin.bt_addbook.addActionListener(this);

        
        v_bookpay.bt_pay.addActionListener(this);
        v_bookpay.bt_back.addActionListener(this);

        for (int i = 0; i < v_bookselect.v_bc.length; i++) {
            v_bookselect.v_bc[i].tbt_image.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    boolean flag = false; // toggle button이 선택되었는지 여부를 확인하는 변수
                    for (int i = 0; i < v_bookselect.v_bc.length; i++) {
                        v_bookselect.v_bc[i].ta_content.setVisible(false);
                    }
                    /*--------------------toggle button 체크 확인------------------*/
                    for (int i = 0; i < v_bookselect.v_bc.length; i++) {
                        if (v_bookselect.v_bc[i].tbt_image.isSelected()) {
                            flag = true;
                            selected_book = i;
                            v_bookselect.v_bc[i].ta_content.setVisible(true);
                        }
                    }

                    /*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
                    if (!flag) {
                        for (int j = 0; j < v_bookselect.v_bc.length; j++) {
                            v_bookselect.v_bc[j].tbt_image.setEnabled(true);
                        }
                    } else {
                        for (int j = 0; j < v_bookselect.v_bc.length; j++)
                            if (selected_book != j) {
                                v_bookselect.v_bc[j].tbt_image.setEnabled(false);
                            }
                    }
                    System.out.println("selected_book : " + selected_book);
                }// mouseReleased
            });// v_schedule.v_sd[i].addMouseListener
        } // for
    }

    public void setClickBookText(int i, boolean flag) {
        v_bookselect.v_bc[i].la_name.setVisible(flag);
        v_bookselect.v_bc[i].la_writer.setVisible(flag);
        v_bookselect.v_bc[i].la_price.setVisible(flag);
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob == v_login.bt_join) {// 회원가입 폼 열기
            v_join.tf_id.setText("");
            v_join.tf_name.setText("");
            v_join.tf_pass.setText("");
            v_join.tf_pass2.setText("");
            v_join.tf_email.setText("");
            v_join.tf_id.requestFocus();
            v_login.setVisible(false);
            v_join.setVisible(true);
        } else if (ob == v_join.bt_submit) { // 회원가입하기
            Member m = new Member();
            m.setId(v_join.tf_id.getText());
            m.setPass(new String(v_join.tf_pass.getPassword()));
            m.setEname(v_join.tf_name.getText());
            m.setEmail(v_join.tf_email.getText());
            m.setGenre(v_join.cb_genre.getSelectedItem().toString());
            if (new MemberDAO().insertJoin(m)) {
                v_join.showMsg("환영합니다^^");
                v_join.setVisible(false);
                v_login.setVisible(true);
            } else {
                v_join.showMsg("가입할 수 없습니다!");
            }
        } else if (ob == v_bookgenre.bt_select) {
            String genre;
            if(v_bookgenre.rb_1.isSelected()) {
                genre = v_bookgenre.rb_1.getText();
            }else if(v_bookgenre.rb_2.isSelected()) {
                genre = v_bookgenre.rb_2.getText();
            }else {
                genre = v_bookgenre.rb_3.getText();             
            }
            new MemberDAO().updateGenre(userid, genre);
            
            v_bookgenre.setVisible(false);
            v_bookselect.setVisible(true);
        } else if (ob == v_bookselect.bt_logout) {
            v_bookselect.setVisible(false);
            v_login.setVisible(true);
        } else if (ob == v_bookselect.bt_genre) {
            v_bookselect.setVisible(false);
            v_bookgenre.setVisible(true);
        } else if (ob == v_login.bt_login) {// 로그인창 시작.
            String id = v_login.tf_id.getText();
            String pass = new String(v_login.tf_pass.getPassword());
            if (id.equals("admin") && pass.equals("manager")) {// 1-1 관리자 로그인
                v_login.showMsg("관리자 로그인 성공!!");
                v_login.setVisible(false);
                v_admin.setVisible(true);
                return;
            }

            if ((new MemberDAO().loginCheck(id, pass))) { // 1.로그인 성공!
                v_login.showMsg(id + "님 환영합니다 ^_^");
                userid = id;
                v_bookselect.la_id.setText(userid + "님");
                /*
                 * list = new BookDAO().recommendBook(new MemberDAO().selectGenre(id));
                 * 
                 * Random random = new Random(); for(int i=0; i<3 ;i++) { // 랜덤한 함수 필요 !! int
                 * ranNum = random.nextInt(list.size())+1; Book book = list.get(ranNum);
                 * 
                 * v_bookselect.v_bc[i].la_name.setText(book.getBname()); }
                 */
                v_login.setVisible(false);
                v_bookselect.setVisible(true); // v_bookselect 로 이동
            } else {
                v_login.showMsg("아이디 또는 비밀번호를 확인해주세요!");
                v_login.tf_id.setText("");
                v_login.tf_id.requestFocus();
                v_login.tf_pass.setText("");
            }
        }else if(ob== v_join.bt_checkid) {
            String id = v_join.tf_id.getText();
            if(new MemberDAO().dupliCheck(id)) {
                v_join.showMsg("중복된 아이디가 존재합니다.");
                v_join.tf_id.setText("");
                v_join.tf_id.requestFocus();
            }
        }else if (ob == v_join.bt_reset) {
            v_join.setVisible(false);
            v_login.setVisible(true);
        } else if (ob == v_bookselect.bt_mypage) {// 마이페이지로 이동
            v_mypage.la_msg.setText(userid + "님 환영합니다.");

            Member m = new MemberDAO().selectMypage(userid);
            v_mypage.la_grade.setText("등급: " + grade[m.getEgrade() - 1]);
            v_mypage.la_cash.setText("캐시: " + m.getCash() + "원");
            v_mypage.la_point.setText("잔여포인트: " + m.getPoint() + "P");

            v_bookselect.setVisible(false);
            v_mypage.setVisible(true);
        }else if(ob==v_bookselect.bt_select){
            
            
            Member m = new MemberDAO().selectMypage("회원 ID: " +userid);
            v_bookpay.la_id.setText(m.getId());
            v_bookpay.la_grade.setText("회원 등급: "+grade[m.getEgrade()-1]);
            v_bookpay.la_point.setText("회원 포인트: "+m.getPoint()+"P");
            
            
            v_bookselect.setVisible(false);
            v_bookpay.setVisible(true);
        }else if (ob == v_mypage.bt_back) {
            v_mypage.setVisible(false);
            v_bookselect.setVisible(true);
        } else if (ob == v_mypage.bt_logout) {
            v_mypage.setVisible(false);
            v_login.setVisible(true);
        } else if (ob == v_mypage.bt_update) {
            Member m = new MemberDAO().selectMemberInfo(userid);
            v_passup.tf_id.setText(m.getId());
            v_passup.tf_name.setText(m.getEname());
            v_passup.tf_email.setText(m.getEmail());
            v_passup.tf_pass.setText("");
            v_passup.tf_pass2.setText("");
            v_passup.tf_pass.requestFocus();
            v_mypage.setVisible(false);
            v_passup.setVisible(true);
        } else if (ob == v_passup.bt_reset) {
            v_passup.setVisible(false);
            v_mypage.setVisible(true);
        } else if (ob == v_passup.bt_submit) {
            String pass = new String(v_passup.tf_pass.getPassword());
            if (new MemberDAO().loginCheck(userid, pass)) {
                v_passup.showMsg("현재와 다른 비밀번호로 변경해주세요!");
                v_passup.tf_pass.setText("");
                v_passup.tf_pass2.setText("");
                v_passup.tf_pass.requestFocus();
                return;
            }
            if (new MemberDAO().updateMemberInfo(userid, pass)) {
                // 비밀번호 변경이 성공한다면
                v_passup.showMsg("비밀번호를 변경하였습니다!");
            } else {
                v_passup.showMsg("비밀번호 변경을 실패하였습니다!");
            }

            v_passup.setVisible(false);
            v_mypage.setVisible(true);
        } else if (ob == v_mypage.bt_history) {
            
            v_mypage.setVisible(false);
            v_history.setVisible(true);
        } else if (ob == v_history.bt_back) {
            v_history.setVisible(false);
            v_mypage.setVisible(true);
        } else if (ob == v_mypage.bt_cash) {
            Member m = new MemberDAO().selectMypage(userid);
            v_cash.la_nowcash.setText("현재 캐시: " + m.getCash()+"원");
            v_cash.tf_cash.setText("");
            v_cash.tf_cash.requestFocus();
            v_mypage.setVisible(false);
            v_cash.setVisible(true);
        } else if (ob == v_cash.bt_back) {
            v_cash.setVisible(false);
            v_mypage.setVisible(true);
        } else if(ob == v_cash.bt_submit) {
            String cashCharge = v_cash.tf_cash.getText();
            if(cashCharge.matches("[\\d]+")) {
                if(new MemberDAO().updateCashCharge(userid, Integer.parseInt(cashCharge))) {
                    v_cash.showMsg(cashCharge+" 원 충전이 완료되었습니다!");
                    v_cash.tf_cash.setText("");
                    v_cash.setVisible(false);
                    v_mypage.setVisible(true);
                }
            }else { 
                v_cash.showMsg("숫자만 입력가능합니다!");
            }
        } else if(ob==v_admin.bt_back) {
            v_admin.setVisible(false);
            v_login.setVisible(true);
        } else if(ob == v_admin.bt_selectallmember) {
            ArrayList<Member> list = new MemberDAO().selectAllMember();
            v_admin.displayTable(list);
            
        } else if(ob == v_admin.bt_selectmember) {
            String id = v_admin.showInputMsg("조회할 회원의 아이디를 입력하세요");
            ArrayList<Member> list = new MemberDAO().selectMember(id);
            v_admin.displayTable(list);
        }else if(ob == v_admin.bt_addquiz) {
            
        }else if(ob == v_admin.bt_addbook) {
            
        }else if(ob == v_admin.bt_selectallbook) {
            
        }else if(ob == v_admin.bt_selectbook) {
            
        }else if(ob == v_bookpay.bt_pay) {
            
        }else if(ob == v_bookpay.bt_back) {
            
        }

    }
}
