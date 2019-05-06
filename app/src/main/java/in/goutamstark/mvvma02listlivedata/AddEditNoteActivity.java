package in.goutamstark.mvvma02listlivedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    private EditText edit_text_title, edit_text_description;
    private NumberPicker number_picker_priority;

    public static final String EXTRA_TITLE =
            "in.goutamstark.mvvma02listlivedata.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "in.goutamstark.mvvma02listlivedata.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "in.goutamstark.mvvma02listlivedata.EXTRA_PRIORITY";
    public static final String EXTRA_ID =
            "in.goutamstark.mvvma02listlivedata.EXTRA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edit_text_title = findViewById(R.id.edit_text_title);
        edit_text_description = findViewById(R.id.edit_text_description);
        number_picker_priority = findViewById(R.id.number_picker_priority);

        number_picker_priority.setMinValue(1);
        number_picker_priority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            edit_text_title.setText(intent.getStringExtra(EXTRA_TITLE));
            edit_text_description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            number_picker_priority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");
        }

    }

    private void saveNote() {
        String title_txt = edit_text_title.getText().toString();
        String description_txt = edit_text_description.getText().toString();
        int priority_int = number_picker_priority.getValue();
        if (title_txt.trim().isEmpty() && description_txt.trim().isEmpty()) {
            Toast.makeText(this, "enter title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title_txt);
        data.putExtra(EXTRA_DESCRIPTION, description_txt);
        data.putExtra(EXTRA_PRIORITY, priority_int);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1){
            data.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
