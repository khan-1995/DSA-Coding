class Solution {
    public String minRemoveToMakeValid(String s) {

        if (s.length() <= 1) {
            return s;
        }

        List<Character> list = new ArrayList<>();
        List<Character> filtered_list = new ArrayList<>();

        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='('){
                count++;
                list.add(ch);
            }else if(ch==')' && count>0){
                list.add(ch);
                count--;
            }else if(ch!=')'){
                list.add(ch);
            }
        }

        for(int i=list.size()-1;i>=0;i--){
            Character ch = list.get(i);

            if(ch=='(' && count>0){
                count--;
            }else{
                filtered_list.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

         Collections.reverse(filtered_list);

        filtered_list.forEach(sb::append);

        
        return sb.toString();
    }

/*Alternate solution
class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> para = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (para.size() != 0 && chars[para.getLast()] == '(') {
                    para.removeLast();
                } else {
                    para.add(i);
                }
            } else if (chars[i] == '(') {
                 para.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (para.size() != 0 && para.getFirst() == i) {
                para.pop();
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
*/
}
