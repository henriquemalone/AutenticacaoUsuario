package autenticacaousuario.cursoandroid.com.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //Login do usuário
        firebaseAuth.signInWithEmailAndPassword("henrique.malone@gmail.com", "teste12").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){ //sucesso ao cadastrar
                    Log.i("signIn", "Sucesso");
                } else{
                    Log.i("signIn", "Falha");
                }
            }
        });

        firebaseAuth.signOut();

        //Verifica usuario logado
        if (firebaseAuth.getCurrentUser() != null) {
            Log.i("verificaUsuario", "Logado");
        } else {
            Log.i("verificaUsuario", "Nao Logado");
        }

        //Cadastro
        firebaseAuth.createUserWithEmailAndPassword("henrique.malone@gmail.com", "teste123").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){ //sucesso ao cadastrar
                    Log.i("createUser", "Sucesso");
                } else{
                    Log.i("createUser", "Falha");
                }
            }
        });
    }
}
