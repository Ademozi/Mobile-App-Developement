package com.supermarket.listview_exo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ArrayList<ProgrammingLanguage> list;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = new ArrayList<>();
        list.add(new ProgrammingLanguage("C++","is a high-level, general-purpose programming language created by Danish computer scientist" +
                " Bjarne Stroustrup. First released in 1985 as an extension of the C programming language," +
                " adding object-oriented (OOP) features, it has since expanded significantly over time adding more OOP and other features;" +
                " as of 1997/C++98 standardization, C++ has added functional features, in addition to facilities for low-level memory manipulation" +
                " for systems like microcomputers or to make operating systems like Linux or Windows, and even later came features like generic programming (through the use of templates)." +
                " C++ is usually implemented as a compiled language, and many vendors provide C++ compilers," +
                " including the Free Software Foundation, LLVM, Microsoft, Intel, Embarcadero, Oracle, and IBM", R.mipmap.cpp));

        list.add(new ProgrammingLanguage("Java","is a high-level, general-purpose, memory-safe, object-oriented programming language." +
                " It is intended to let programmers write once, run anywhere (WORA), meaning that compiled Java code" +
                " can run on all platforms that support Java without the need to recompile. Java applications are typically compiled" +
                " to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture." +
                " The syntax of Java is similar to C and C++," +
                " but has fewer low-level facilities than either of them. The Java runtime provides dynamic capabilities" +
                " (such as reflection and runtime code modification) that are typically not available in traditional compiled languages.", R.mipmap.java));

        list.add(new ProgrammingLanguage("JavaScript","(JS) is a programming language and core technology of the Web, alongside HTML and CSS. It was created by Brendan Eich in 1995. As of 2025," +
                " the overwhelming majority of websites (98.9%) uses JavaScript for client side webpage behavior." +
                " \\n Web browsers have a dedicated JavaScript engine that executes the client code." +
                " These engines are also utilized in some servers and a variety of apps." +
                " The most popular runtime system for non-browser usage is Node.js." +
                " \\n JavaScript is a high-level, often just-in-time–compiled language that conforms to the ECMAScript standard." +
                " It has dynamic typing, prototype-based object-orientation, and first-class functions." +
                " It is multi-paradigm, supporting event-driven, functional, and imperative programming styles." +
                " It has application programming interfaces (APIs) for working with text," +
                " dates, regular expressions, standard data structures, and the Document Object Model (DOM).", R.mipmap.javascript));

        list.add(new ProgrammingLanguage("Pyhton","(is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation." +
                " Python is dynamically type-checked and garbage-collected. It supports multiple programming paradigms, including" +
                " structured (particularly procedural), object-oriented and functional programming.\\n Guido van Rossum began" +
                " working on Python in the late 1980s as a successor to the ABC programming language. Python 3.0, released in 2008," +
                " was a major revision and not completely backward-compatible with earlier versions. Beginning with Python 3.5," +
                " capabilities and keywords for typing were added to the language, allowing optional static typing." +
                " As of 2026, the Python Software Foundation supports Python 3.10, 3.11, 3.12, 3.13, and 3.14," +
                " following the project's annual release cycle and five-year support policy. Python 3.15" +
                " is currently in the alpha development phase, and the stable release is expected to come out in October 2026." +
                " Earlier versions in the 3.x series have reached end-of-life and no longer receive security updates.", R.mipmap.python));

        list.add(new ProgrammingLanguage("PHP","is a general-purpose scripting language geared towards web development." +
                " It was created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. The PHP" +
                " reference implementation is now produced by the PHP Group. PHP was originally an abbreviation of Personal Home Page," +
                " but it now stands for the recursive backronym PHP: Hypertext Preprocessor.\\n PHP code is usually processed on" +
                " a web server by a PHP interpreter implemented as a module, a daemon or a Common Gateway Interface (CGI) executable." +
                " On a web server, the result of the interpreted and executed PHP code—which may be any type of data, such" +
                " as generated HTML or binary image data—can form the whole or part of an HTTP response. Various web template systems," +
                " web content management systems, and web frameworks exist that can be employed to orchestrate or facilitate" +
                " the generation of that response. Additionally, PHP can be used for programming tasks outside the web context," +
                " though non-web uses are rare. PHP code can also be directly executed from the command line.", R.mipmap.php));

        list.add(new ProgrammingLanguage("Swift"," is a high-level general-purpose, multi-paradigm, compiled programming" +
                " language created by Chris Lattner in 2010 for Apple Inc. and maintained by the open-source community." +
                " Swift compiles to machine code and uses an LLVM-based compiler. Swift was first released in June 2014" +
                " and the Swift toolchain has shipped in Xcode since Xcode version 6, released in September 2014.\\n Apple intended" +
                " Swift to support many core concepts associated with Objective-C, notably dynamic dispatch, widespread late binding," +
                " extensible programming, and similar features, but in a \"safer\" way, making it easier to catch" +
                " software bugs; Swift has features addressing some common programming errors like null pointer dereferencing and" +
                " provides syntactic sugar to help avoid the pyramid of doom. Swift supports the concept of protocol extensibility," +
                " an extensibility system that can be applied to types, structs and classes, which Apple promotes as a real change in" +
                " programming paradigms they term \"protocol-oriented programming\" (similar to traits and type classes).", R.mipmap.swift));


        MyAdapter adapter = new MyAdapter(this,list);

        ListView listView = this.findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ProgrammingLanguageActivity.class);
                intent.putExtra("logo", list.get(i).logo);
                intent.putExtra("name", list.get(i).name);
                intent.putExtra("description", list.get(i).description);

                startActivity(intent);
            }
        });

    }
}