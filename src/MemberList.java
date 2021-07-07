import java.util.Iterator;
import java.util.List;

class MemberList {
    private List<Member> members;

    private static MemberList memberList;
    public static MemberList instance() {
        if (memberList == null) {
            return memberList = new MemberList();
        } else {
            return memberList;
        }
    }

    public Member search(String memberId) {
//      for (Iterator iterator = members.iterator(); iterator.hasNext(); ) {
//          Member member = (Member) iterator.next();
//          if (member.)
//      }
        return null;
    }

    public boolean insertMember(Member member) {
        return this.members.add(member);
    }

    public Iterator<Member> getMembers() {
        return this.members.iterator();
    }
}
