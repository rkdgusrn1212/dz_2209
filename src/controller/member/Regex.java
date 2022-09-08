package controller.member;

class Regex{
    static final String EMAIL = "[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    static final String EMAIL_WARN = "알맞는 이메일 형식이 아닙니다.\n다시 입력해 주십시오.";
    static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$";
    static final String PASSWORD_WARN = "비밀번호는 숫자, 영문자, 특수문자를 각각 하나이상 포함하고 8자이상 16자 이하여야 합니다.\n다시 입력해 주십시오.";
    static final String ID = "^[a-zA-Z0-9_]{6,20}$";
    static final String ID_WARN = "ID는 6글자 이상 20글자 이하의 영문자, 숫자, 언더바만 입력 가능합니다.\n다시 입력해 주십시오.";
}
