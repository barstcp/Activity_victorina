package a4c.victorina;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<Question> questions = new ArrayList<>();
        questions.add(new Question("Как заканчивается присказка: «Мы и сами с…»?", "с волосами", "с усами", " с часами", " Нс долгами", 2));
        questions.add(new Question("С помощью чего пасссажиры часто попадают в самолет? ", "рукава", "воротника", " лацкана", " манжеты", 1));
        questions.add(new Question("Какой клетки нет на шахматной доске ?", "h8", "b7", " k6", " g5", 3));
        questions.add(new Question("Что не собирают?", "коллекцию", "коррупцию", " конструкцию", " информацию", 2));
        questions.add(new Question("На что надевают брекеты?", "на пальцы", "на уши", " на волосы", " на зубы", 4));
        questions.add(new Question("Что говорят о человеке, которому до всего есть дело ?", "«В каждой бочке затычка»", "В каждой строчке ошибка", " В каждой чашке заварка", " В каждой шине заплатка»", 1));
        questions.add(new Question("Как называется хищное растение?", "Куторама", "Плашетие", " Наган", " Дурабак", 2));
        questions.add(new Question("Что бывает у шапки?", "Уши", "Нос", " палец", " ноги", 1));
        questions.add(new Question("Что не использовалось для разогрева утюгов различных конструкции?", "Телевизор", "Планшет", " Телефон", " Ноутбук", 3));
        questions.add(new Question("Какое прозвище дали бюрократу?", "крыса", "Пл435аншет", " Телефон", " Ноутбук", 1));
        questions.add(new Question("Какой удар есть в арсенале теннисиста?", "резанный", "Планшет", " Телефон", " Ноутбук", 1));
        questions.add(new Question("то является одной из характеристик двигателя автомобиля?", "крутящий момент", "План534шет", " Телеegфон", " Ноутбук", 1));

        final TextView textView = (TextView) findViewById(R.id.question);
        final TextView textView1 = (TextView) findViewById(R.id.count);

        final Button button1 = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);

        final Drawable drawable = button1.getBackground();

        final Random random = new Random();
        int randomNumber = random.nextInt(questions.size());

        final int[] a = rnd(questions.size());


        textView.setText(questions.get(randomNumber).question1);
        button1.setText(questions.get(randomNumber).answer1);
        button2.setText(questions.get(randomNumber).answer2);
        button3.setText(questions.get(randomNumber).answer3);
        button4.setText(questions.get(randomNumber).answer4);


        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                int b = Integer.valueOf(textView1.getText().toString());

                if (b >= questions.size()) {
                    Toast.makeText(MainActivity.this, "Выйграли", Toast.LENGTH_LONG).show();
                    return;
                }

                android.os.Handler handler = new android.os.Handler();

                Runnable r = new Runnable() {
                    public void run() {
                        //Toast.makeText(MainActivity.this, "rrr", Toast.LENGTH_LONG).show();
                        button1.setBackgroundColor(getResources().getColor(R.color.red));
                        textView1.setText("0");
                    }
                };

                Runnable r1 = new Runnable() {
                    public void run() {
                        //Toast.makeText(MainActivity.this, "r11111", Toast.LENGTH_LONG).show();
                        button1.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                };

                Runnable r2 = new Runnable() {
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        b += 1;
                        textView1.setText(String.valueOf(b));
                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);


                    }
                };

                Runnable r3 = new Runnable() {
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        //b += 1;
                        textView1.setText(String.valueOf(b));
                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);


                    }
                };


                button1.setBackgroundColor(getResources().getColor(R.color.yellow));

                if (questions.get(a[b]).trueAnswer != 1) {
                    handler.postDelayed(r, 3000);
                    handler.postDelayed(r3, 4000);

                    Toast.makeText(MainActivity.this, "Неверно", Toast.LENGTH_LONG).show();
                } else {

                   // Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_LONG).show();
                   // button1.setBackgroundColor(getResources().getColor(R.color.yellow));
                    handler.postDelayed(r1, 3000);
                    handler.postDelayed(r2, 4000);

                    //Toast.makeText(MainActivity.this, "sleep", Toast.LENGTH_LONG).show();

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int b = Integer.valueOf(textView1.getText().toString());

                if (b >= questions.size()) {
                    Toast.makeText(MainActivity.this, "Выйграли", Toast.LENGTH_LONG).show();
                    return;
                }

                android.os.Handler handler = new android.os.Handler();

                Runnable r = new Runnable() {
                    public void run() {
                        textView1.setText("0");
                        //Toast.makeText(MainActivity.this, "rrr", Toast.LENGTH_LONG).show();
                        button2.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                };

                Runnable r1 = new Runnable() {
                    public void run() {
                        //Toast.makeText(MainActivity.this, "r11111", Toast.LENGTH_LONG).show();
                        button2.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                };

                Runnable r2 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        b += 1;
                        textView1.setText(String.valueOf(b));

                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);
                    }
                };

                Runnable r3 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        //b += 1;
                        //textView1.setText(String.valueOf(b));
                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);


                    }
                };

                button2.setBackgroundColor(getResources().getColor(R.color.yellow));

                if (questions.get(a[b]).trueAnswer != 2) {
                    handler.postDelayed(r, 3000);
                    handler.postDelayed(r3, 4000);

                    Toast.makeText(MainActivity.this, "Неверно", Toast.LENGTH_LONG).show();
                } else {

                    //Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_LONG).show();
                    button2.setBackgroundColor(getResources().getColor(R.color.yellow));
                    handler.postDelayed(r1, 3000);
                    handler.postDelayed(r2, 4000);

                    //Toast.makeText(MainActivity.this, "sleep", Toast.LENGTH_LONG).show();

                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int b = Integer.valueOf(textView1.getText().toString());

                if (b >= questions.size()) {
                    Toast.makeText(MainActivity.this, "Выйграли", Toast.LENGTH_LONG).show();
                    return;
                }

                android.os.Handler handler = new android.os.Handler();

                Runnable r = new Runnable() {
                    public void run() {
                        textView1.setText("0");
                        //Toast.makeText(MainActivity.this, "rrr", Toast.LENGTH_LONG).show();
                        button3.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                };

                Runnable r1 = new Runnable() {
                    public void run() {
                        //Toast.makeText(MainActivity.this, "r11111", Toast.LENGTH_LONG).show();
                        button3.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                };

                Runnable r2 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        b += 1;
                        textView1.setText(String.valueOf(b));


                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);
                    }
                };

                Runnable r3 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        //b += 1;
                        textView1.setText(String.valueOf(b));
                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);


                    }
                };

                button3.setBackgroundColor(getResources().getColor(R.color.yellow));

                if (questions.get(a[b]).trueAnswer != 3) {
                    handler.postDelayed(r, 3000);
                    handler.postDelayed(r3, 4000);

                    Toast.makeText(MainActivity.this, "Неверно", Toast.LENGTH_LONG).show();
                } else {

                    //Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_LONG).show();
                    button3.setBackgroundColor(getResources().getColor(R.color.yellow));
                    handler.postDelayed(r1, 3000);
                    handler.postDelayed(r2, 4000);

                    //Toast.makeText(MainActivity.this, "sleep", Toast.LENGTH_LONG).show();

                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int b = Integer.valueOf(textView1.getText().toString());

                if (b >= questions.size()) {
                    Toast.makeText(MainActivity.this, "Выйграли", Toast.LENGTH_LONG).show();
                    return;
                }

                android.os.Handler handler = new android.os.Handler();

                Runnable r = new Runnable() {
                    public void run() {
                        textView1.setText("0");
                        //Toast.makeText(MainActivity.this, "rrr", Toast.LENGTH_LONG).show();
                        button4.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                };

                Runnable r1 = new Runnable() {
                    public void run() {
                        //Toast.makeText(MainActivity.this, "r11111", Toast.LENGTH_LONG).show();
                        button4.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                };

                Runnable r2 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        b += 1;
                        textView1.setText(String.valueOf(b));

                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);
                    }
                };

                Runnable r3 = new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    public void run() {
                        int b = Integer.valueOf(textView1.getText().toString());
                        //b += 1;
                        textView1.setText(String.valueOf(b));
                        button1.setBackground(drawable);
                        button2.setBackground(drawable);
                        button3.setBackground(drawable);
                        button4.setBackground(drawable);

                        textView.setText(questions.get(a[b]).question1);
                        button1.setText(questions.get(a[b]).answer1);
                        button2.setText(questions.get(a[b]).answer2);
                        button3.setText(questions.get(a[b]).answer3);
                        button4.setText(questions.get(a[b]).answer4);


                    }
                };

                button4.setBackgroundColor(getResources().getColor(R.color.yellow));

                if (questions.get(a[b]).trueAnswer != 4) {
                    handler.postDelayed(r, 3000);
                    handler.postDelayed(r3, 4000);

                    Toast.makeText(MainActivity.this, "Неверно", Toast.LENGTH_LONG).show();
                } else {

                    //Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_LONG).show();

                    handler.postDelayed(r1, 3000);
                    handler.postDelayed(r2, 4000);

                    //Toast.makeText(MainActivity.this, "sleep", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    public int[] rnd(int length) {
        Random random = new Random();
        int[] a = new int[length + 1];
        int leng = length;

        for (int i = 0; i <= length; i++) {
            a[i] = random.nextInt(leng);
        }

        return a;
    }

    public class Question {
        String question1;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        final int trueAnswer;

        public String getQuestion() {
            return question1;
        }

        public void setQuestion(String question) {
            this.question1 = question;
        }

        public String getAnswer1() {
            return answer1;
        }

        public void setAnswer1(String answer1) {
            this.answer1 = answer1;
        }

        public String getAnswer2() {
            return answer2;
        }

        public void setAnswer2(String answer2) {
            this.answer2 = answer2;
        }

        public String getAnswer3() {
            return answer3;
        }

        public void setAnswer3(String answer3) {
            this.answer3 = answer3;
        }

        public String getAnswer4() {
            return answer4;
        }

        public void setAnswer4(String answer4) {
            this.answer4 = answer4;
        }

        public int getTrueAnswer() {
            return trueAnswer;
        }


        public Question(String question, String answer1, String answer2, String answer3, String answer4, int trueAnswer) {
            this.question1 = question;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
            this.answer4 = answer4;
            this.trueAnswer = trueAnswer;
        }
    }
}

