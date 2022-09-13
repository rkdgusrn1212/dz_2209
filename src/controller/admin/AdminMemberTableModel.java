package controller.admin;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import isbn.ISBN;
import model.vo.Book;
import model.vo.Member;

public class AdminMemberTableModel extends AbstractTableModel {


    private ArrayList<Member> memberList = new ArrayList<>();//오로지 제목, 저자, 카테고리, 대여여부만 가진다.

    public void update(ArrayList<Member> list) {
        memberList = (ArrayList<Member>) list.clone();//이후 book의 수정에 독립적. 
    }

    public Member getModel(int idx) {       
        if(idx<getRowCount()&&idx>=0) {
            return memberList.get(idx);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return memberList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = memberList.get(rowIndex);
        switch(columnIndex) {
        case 0:
            return member.getId();
        case 1:
            return member.getName();
        case 2:
            return member.getEmail();
        case 3:
            return ISBN.convertCategory(member.getInterestCategory());
        }
        return null;
    }



    @Override
    public String getColumnName(int column) {
        switch(column) {
        case 0:
            return "ID";
        case 1:
            return "이 름";
        case 2:
            return "이메일";
        case 3:
            return "관심 분야";
        }
        return super.getColumnName(column);
    }

}
