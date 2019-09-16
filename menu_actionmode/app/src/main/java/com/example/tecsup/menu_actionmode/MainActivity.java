package com.example.tecsup.menu_actionmode;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.Month;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv_1);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null){
                    return false;
                }

                actionMode = MainActivity.this.startActionMode(actionModeCallback);
                v.setSelected(true);
                return true;
            }
        });
    }

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.itm_eliminar:
                    Toast.makeText(MainActivity.this,"eliminar",Toast.LENGTH_SHORT).show();
                    MostarDialogEliminar();
                break;
                case R.id.itm_editar:
                    Toast.makeText(MainActivity.this,"editar",Toast.LENGTH_SHORT).show();
                    MostrarDialogoFecha();

                break;
            }


            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    void  MostarDialogEliminar(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this)
        .setTitle("Confirme eliminar")
        .setMessage("al eliminar se borrarr la informacion")
        .setPositiveButton("eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"se esta eliminando",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("cancelar",null);
        builder.show();
    }

    void MostrarDialogoFecha(){
        DatePickerDialog datePickerDialog =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this,year +" " + month + " " + dayOfMonth ,Toast.LENGTH_SHORT).show();
            }
        }, 2019,8,9);
        datePickerDialog.show();
    }
}


