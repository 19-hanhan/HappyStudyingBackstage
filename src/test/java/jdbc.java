import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;

import java.util.List;
import java.util.Map;

public class jdbc {
    public static void main(String[] args) {
        adminDao dao = new ImpladminDao();
        admin tmp = new admin(); tmp.setaName("root"); tmp.setaPassword("password");
        dao.addAdmin(tmp);

//        dao.delAdmin(10000003);
//        dao.delAdmin(10000000);

//        Map<String, Object> tmp = dao.findAdminById(10000000);
//        System.out.println(tmp);
//        dao.updateAdmin(new admin((int)tmp.get("a_id"), "456", (String)tmp.get("a_name"), (String)tmp.get("a_email")));
        List<Map<String, Object>> ls = dao.findAllAdmin();
//        Map<String, Object> ls = dao.findAdminByEmail("root");
        System.out.println(ls);
//        System.out.println(ls.get(0).get("a_name"));
//        int cnt = dao.clacAdminCount();
//        System.out.println(cnt);
    }
}
