import java.util.ArrayList;

//class Generate_perentheses {
//    public static void main(String[] args) {
//        System.out.println(generateParenthesis(new ArrayList<>(),"()",4));
//    }
//    public static ArrayList<String> generateParenthesis(ArrayList<String> list,String p,int n) {
//        if(n==1) {
//            if (!list.contains(p)) {
//                list.add(p);
//            }
//            return list;
//        }
//        generateParenthesis(list,"()"+p,n-1);
//        generateParenthesis(list,p+"()",n-1);
//        generateParenthesis(list,"("+p+")",n-1);
//
//        return list;
//    }
//}



    class GenerateParentheses {
        public static ArrayList<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<String>();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        public static void backtrack(ArrayList<String> result, String current, int open, int close, int max) {
            if (current.length() == max * 2) {
                result.add(current);
                return;
            }

            if (open < max) {
                backtrack(result, current + "(", open + 1, close, max);
            }

            if (close < open) {
                backtrack(result, current + ")", open, close + 1, max);
            }
        }

        public static void main(String[] args) {
            int n = 4;
            ArrayList<String> result = generateParenthesis(n);
            System.out.println(result);
        }
    }