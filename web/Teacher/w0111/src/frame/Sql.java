package frame;

public class Sql {
	// User SQL
	public static String userInsert = 
	"INSERT INTO GAME_USER VALUES (?,?,?)";
	public static String userUpdate = 
	"UPDATE GAME_USER SET PWD=?, NAME=? WHERE ID=?";
	public static String userDelete = 
	"DELETE FROM GAME_USER WHERE ID=?";
	public static String userSelect = 
	"SELECT * FROM GAME_USER WHERE ID=?";
	public static String userSelectAll = 
	"SELECT * FROM GAME_USER ORDER BY ID ASC";
	
	// Item SQL
	public static String itemInsert = 
	"INSERT INTO GAME_ITEM VALUES (ITEM_SEQ.NEXTVAL,?,?,SYSDATE)";
	public static String itemUpdate = 
	"UPDATE GAME_ITEM SET NAME=?, PRICE=? WHERE ID=?";
	public static String itemDelete = 
	"DELETE FROM GAME_ITEM WHERE ID=?";
	public static String itemSelect = 
	"SELECT * FROM GAME_ITEM WHERE ID=?";
	public static String itemSelectAll = 
	"SELECT * FROM GAME_ITEM ORDER BY ID ASC";
	
	public static String userItemSelect = 
	"SELECT u.ID, u.USER_ID, u.ITEM_ID, g.NAME AS ITEM_NAME, u.QT FROM USER_ITEM u, GAME_ITEM g WHERE u.item_id = g.id  AND USER_ID = ?";
}








