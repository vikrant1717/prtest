public class Block extends Reader {

    public void loop() {
        // int i=0;

        for (int i = 33; i >= 0; i--) {
            System.out.print(i);
        }


    }

  /*public void example(){

        String sample="nehaNIMBALKAR";

      System.out.println(sample.length());  //sample.length();

      for (int i=11;i<=sample.length();i++)

      {
          System.out.println(sample.toUpperCase());
          System.out.println(sample.toLowerCase());

      }




  }*/

  public void combinations()
  {

              String[] names = {"virat", "rohit", "KL", "Bumrah", "Shami","Jadeja","Warner","Marnus","Starc","Zampa"};

              for (int i = 0; i < names.length; i++) {
                  for (int j = i + 1; j < names.length; j++) {
                      for (int k = j + 1; k < names.length; k++) {
                          String combination = names[i] + " " + names[j] + " " + names[k];
                          System.out.println(combination);
                      }
                  }
              }
          }
      }






