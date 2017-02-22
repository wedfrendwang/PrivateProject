package wedfrend.wang.privateproject.savedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import wedfrend.wang.privateproject.R;

public class FilesActivity extends AppCompatActivity {

    private static final String TAG = "FilesActivity";
    TextView show_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_activity);

        show_content = ((TextView) findViewById(R.id.show_content));
        findViewById(R.id.saveDataToFiles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToFiles("我们明明知道空气很毒，却还要呼吸；\n"+"明明知道泡面很脏，却还要充饥；\n"+"明明知道一线大城市房价坐地上涨，却还要削尖脑袋往里挤。\n"+"我们这么努力，只是为了追上那个曾经被寄予厚望的自己。");
            }
        });

        findViewById(R.id.getDataToFiles).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = getDataToFiles();
                show_content.setText(message);

            }
        });
    }


    /**
     * 存储方法
     * @param string
     */
    private void saveDataToFiles(String string){
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = openFileOutput("data",MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            Toast.makeText(FilesActivity.this,"success",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取文件中的数据
     * @return
     */
    private String getDataToFiles(){

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileInputStream = openFileInput("data");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(bufferedReader != null){
                    bufferedReader.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return stringBuilder.toString();
    }
}
