package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static final MemberRepository instance = new MemberRepository();
    private static Map<Long, Member>
            store = new HashMap<>();
    private static long sequence = 0L;

    /**
     * 싱글톤으로 사용하기 위해서 기본생성자를 private로 만듦.
     */
    private MemberRepository() {
    }

    /**
     * 기본 생성자의 생성을 막았기 때문에 인스턴스를 가져올 메서드를 만듦.
     *
     * @return
     */
    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
