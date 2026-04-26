package Main.Library;

import static Main.Library.MemberService.listPerson;

public class Search {

    public static  Member findMemberById(int id){
        Member result =  null;
        for (Member m : listPerson){
            if (id ==  m.getMemberId()){
                result = m ;
                break;
            }
        }
        return result;
    }
    public static Member findMemberByName(String member){
        Member result = null;
        for (Member m : listPerson){
            if (member.equalsIgnoreCase(m.getName())){
                result = m;
                break ;
            }
        }
        return result;
    }
}
