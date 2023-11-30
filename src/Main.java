import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException
    {
Movie movies[] =new Movie[3];

File file= new File("Data" + File.separator + "Movies.txt");

ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));


        movies[1]=new Movie(1,"PrinceOfTheSeas", )

//  movies[i]=(Movie)ois.readObject();




}
movies[1]= (Movie)ois.readObject();


    }
}