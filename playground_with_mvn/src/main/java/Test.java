import java.io.File;

public class Test {

    private File folderToRead;

    public Test(File folderToRead) {
        this.folderToRead = folderToRead;
    }

    private static final String AM_FILE_CSV_TEMPLATE =
            "\"FILE_ID\", \"FILE_NAME\", \"FILE_TYPE\", \"FILE_SIZE\", \"FILE_DATA\", \"RELATES_TO\", "
                    + "\"CREATEDAT\", \"CREATEDBY\", \"UPDATEDAT\", \"UPDATEDBY\", \"DELETEDAT\", \"DELETEDBY\" \n"
                    + "\"%{fileId}\", \"%{fileName}\", \"zip\", \"%{size}\", \"%{hex}\", \"REPORT_TEMPLATE\", "
                    + "\"%{createdAt}\", \"mWVznM0cV8dLzVXMXUVH_w\", \"NULL\", \"NULL\", \"NULL\", \"NULL\" ";

    public void printString(){
        System.out.println(AM_FILE_CSV_TEMPLATE);
    }

    public void test(){
        for (File s : folderToRead.listFiles()) {
            System.out.println(s.getParent());
        }
    }


}

