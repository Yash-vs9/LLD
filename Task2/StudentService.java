package Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class StudentService {
    static ArrayList<Student> fakeDB = new ArrayList<>();

    public static String addStudent(Student body){
        fakeDB.add(body);
        return "ADDED";
    }

    public static String rmStudent(Long id){
        Iterator<Student> iterator = fakeDB.iterator();
        while(iterator.hasNext()){
            Student st = iterator.next();
            if(st.getId().equals(id)){
                iterator.remove();
                return "REMOVED";
            }
        }
        return "STUDENT NOT FOUND";
    }

    public static String updateStudent(Student body){
        for(Student st : fakeDB){
            if(st.getId().equals(body.getId())){
                st.setAge(body.getAge());
                st.setCourses(body.getCourses());
                st.setMarks(body.getMarks());
                st.setName(body.getName());
                return "UPDATED";
            }
        }
        return "STUDENT NOT FOUND";
    }

    public static Optional<Student> getStudentById(Long id){
        return fakeDB.stream()
                .filter(st -> st.getId().equals(id))
                .findFirst();
    }
    public static void showList(){
        System.out.println(fakeDB);
    }

    public static void main(String[] args) {


    }
}