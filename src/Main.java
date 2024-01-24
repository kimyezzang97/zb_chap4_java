import java.sql.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public void dbSelect(){
        String url = "jdbc:mariadb://172.30.1.38:3306/test";
        String dbUserId = "kyc";
        String dbPassword = "kyc1234";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 1. 드라이버 로드
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook
        String memberTypeValue = "email";
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 2. 커넥션 객체 생성

            String sql = "select member_type, user_id, password, name" +
                    " from member " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql); // 3. 프리페어드스테이트먼트 객체 생성
            preparedStatement.setString(1, memberTypeValue);

            rs = preparedStatement.executeQuery(); // 4. 쿼리 실행

            while(rs.next()){ // 5. 결과 수행
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally { // 6. 객체 연결 해제 (close)
            try {
                if(rs != null && rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null && preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(connection != null && connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void dbInsert(){
        String url = "jdbc:mariadb://172.30.1.38:3306/test";
        String dbUserId = "kyc";
        String dbPassword = "kyc1234";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 1. 드라이버 로드
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook
        String memberTypeValue = "email";
        String userIdValue = "kyc@naver.com";
        String passwordValue = "3333";
        String nameValue = "김예짱";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 2. 커넥션 객체 생성

            String sql = "insert into member (member_type, user_id, password, name) " +
                    "values (?, ? ,?, ?)";

            preparedStatement = connection.prepareStatement(sql); // 3. 프리페어드스테이트먼트 객체 생성
            preparedStatement.setString(1, memberTypeValue);
            preparedStatement.setString(2, userIdValue);
            preparedStatement.setString(3, passwordValue);
            preparedStatement.setString(4, nameValue);

            int affectedRows = preparedStatement.executeUpdate(); // 4. 쿼리 실행

            if(affectedRows > 0) System.out.println(" 저장 성공 ");
            else System.out.println(" 저장 실패 ");

        } catch (SQLException e){
            e.printStackTrace();
        } finally { // 6. 객체 연결 해제 (close)
            try {
                if(rs != null && rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null && preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(connection != null && connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void dbUpdate(){
        String url = "jdbc:mariadb://172.30.1.38:3306/test";
        String dbUserId = "kyc";
        String dbPassword = "kyc1234";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 1. 드라이버 로드
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook
        String memberTypeValue = "email";
        String userIdValue = "kyc@naver.com";
        String passwordValue = "9999";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 2. 커넥션 객체 생성

            String sql = "update member " +
                    "set " +
                    "     password = ? " +
                    "where member_type = ? " +
                    "   and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql); // 3. 프리페어드스테이트먼트 객체 생성
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);

            int affectedRows = preparedStatement.executeUpdate(); // 4. 쿼리 실행

            if(affectedRows > 0) System.out.println(" 수정 성공 ");
            else System.out.println(" 수정 실패 ");

        } catch (SQLException e){
            e.printStackTrace();
        } finally { // 6. 객체 연결 해제 (close)
            try {
                if(rs != null && rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null && preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(connection != null && connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void dbDelete(){
        String url = "jdbc:mariadb://172.30.1.38:3306/test";
        String dbUserId = "kyc";
        String dbPassword = "kyc1234";

        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 1. 드라이버 로드
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // email, kakao, facebook
        String memberTypeValue = "email";
        String userIdValue = "kyc@naver.com";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword); // 2. 커넥션 객체 생성

            String sql = "delete from member " +
                    "where member_type = ? and user_id = ?";

            preparedStatement = connection.prepareStatement(sql); // 3. 프리페어드스테이트먼트 객체 생성
            preparedStatement.setString(1, memberTypeValue);
            preparedStatement.setString(2, userIdValue);

            int affectedRows = preparedStatement.executeUpdate(); // 4. 쿼리 실행

            if(affectedRows > 0) System.out.println(" 삭제 성공 ");
            else System.out.println(" 삭제 실패 ");

        } catch (SQLException e){
            e.printStackTrace();
        } finally { // 6. 객체 연결 해제 (close)
            try {
                if(rs != null && rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null && preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if(connection != null && connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        //T.dbSelect();
        //T.dbInsert();
        //T.dbUpdate();
        T.dbDelete();

    }


}