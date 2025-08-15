public class sBuilder {


    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder("nimbalkar");


        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            System.out.println(back);


            char frontchar = sb.charAt(front);

            char backchar = sb.charAt(back);

            sb.setCharAt(front, backchar);
            sb.setCharAt(back, frontchar);


        }


   System.out.println(sb);
//
//
//        System.out.println(sb.charAt(2));
////
////        sb.setCharAt(2,'e');
////        System.out.println(sb);
//
//        sb.insert(0,'n');
//
//       System.out.println(sb);
//
//        sb.delete(0,1);
//        System.out.println(sb);


    }
}
