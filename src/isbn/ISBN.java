package isbn;

public class ISBN {
    public final static String[] CATEGORY_ARRAY = {"종류", "철학, 심리학, 윤리학", "종교", "사회과학", "순수과학", "기술과학", "예술", "어학", "문학", "역사, 지리, 관광"};
    public static String convertCategory(int category) {
        return CATEGORY_ARRAY[category];
    }
}
