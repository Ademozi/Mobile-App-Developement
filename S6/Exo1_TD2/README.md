
# Currency Converter App

---

# JAVA -> Logic :

# onCreate() Method

```java
protected void onCreate(Bundle savedInstanceState)
```

This method is **called when the activity starts**.

**English:** Initializes the screen.
**Français :** Initialise l'écran.

---

## Set Layout

```java
setContentView(R.layout.activity_main);
```

This connects the **Java code with the XML UI**.

```
MainActivity.java
        ↓
activity_main.xml
```

---

# Connecting Variables to UI

```java
edit = this.findViewById(R.id.ed);
rb1 = this.findViewById(R.id.r1);
rb2 = this.findViewById(R.id.r2);
text = this.findViewById(R.id.txt);
```

**findViewById()** links Java variables with the **XML elements**.

Example:

```
XML
EditText id="ed"

↓

Java
EditText edit = findViewById(R.id.ed);
```

Now the program can **read or change the UI element**.

---

# TextWatcher

```java
edit.addTextChangedListener(new TextWatcher()
```

This listens for **text changes in the input field**.

**English:** When the user types, the program reacts.
**Français :** Le programme détecte **chaque modification du texte**.

---

## Important Method

```java
afterTextChanged(Editable editable) {
    calculate();
}
```

When the user **finishes typing**, it calls:

```
calculate()
```

So the conversion happens **automatically while typing**.

---

# convert() Method

```java
public void convert(View view){
    calculate();
}
```

This method is called when the **button or radio button is clicked**.

In XML you had:

```xml
android:onClick="convert"
```

So when the user clicks:

```
Button
RadioButton
```

Android runs:

```
convert()
```

---

# calculate() Method (Main Logic)

```java
public void calculate()
```

This is the **currency conversion algorithm**.

---

## Step 1: Get Input

```java
String str = edit.getText().toString();
```

Gets the value typed by the user.

Example:

```
User types: 10
str = "10"
```

---

## Step 2: Check if Empty

```java
if (str.isEmpty())
```

If the user didn't type anything.

Then:

```java
text.setTextColor(Color.RED);
text.setText("Error!");
```

Result:

```
Error!
```

in **red color**.

---

## Step 3: Convert Text to Number

```java
double input_d = Double.parseDouble(str);
```

Converts text into a number.

Example:

```
"10" → 10.0
```

---

# Conversion Logic

### Case 1: Euro → DZD

```java
if (rb1.isChecked())
```

Checks if **Euro → DZD** radio button is selected.

Then:

```java
d = 153.25 * input_d;
```

Example:

```
10 Euro

10 × 153.25 = 1532.5 DZD
```

Result:

```java
text.setText(d + " DZD");
```

---

### Case 2: DZD → Euro

```java
if (rb2.isChecked())
```

Then:

```java
d = 0.0065 * input_d;
```

Example:

```
1000 DZD

1000 × 0.0065 = 6.5 Euro
```

Result:

```
6.5 Euro
```

---

# Final App Behavior

User experience:

```
Type number
      ↓
Select conversion
      ↓
Result appears automatically
```

Example:

```
Input: 10
Selected: Euro → DZD

Result:
1532.5 DZD
```

---

# XML layouts -> the design of the screen :

This file is an **Android layout XML file**. It defines the **user interface (UI)** of your app screen. In Android development:

* **XML layouts** describe the design of the screen.
* **Java/Kotlin code** controls the logic.

Since you're learning Android development, I'll explain **each line step-by-step**.

---

# 1. XML Declaration

```xml
<?xml version="1.0" encoding="utf-8"?>
```

### Explanation

* This tells the system that the file is an **XML document**.
* `version="1.0"` → XML version.
* `encoding="utf-8"` → character encoding used in the file.

---

# 2. Root Layout (ConstraintLayout)

```xml
<androidx.constraintlayout.widget.ConstraintLayout
```

### Explanation

This is the **main container of the screen**.

**English:** ConstraintLayout
**French:** Mise en page par contraintes

It allows you to position UI elements using **constraints** relative to other elements.

---

```xml
xmlns:android="http://schemas.android.com/apk/res/android"
```

### Explanation

Defines the **Android namespace**.

It allows you to use Android attributes like:

```
android:layout_width
android:text
android:id
```

---

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

### Explanation

Used for **custom attributes** used by Android libraries like:

```
app:layout_constraintTop_toTopOf
```

---

```xml
xmlns:tools="http://schemas.android.com/tools"
```

### Explanation

Used **only in Android Studio preview**.

It does **not affect the real application**.

Example:

```
tools:context
tools:layout_editor_absoluteX
```

---

```xml
android:id="@+id/main"
```

### Explanation

Creates an **ID for this layout**.

* `@+id` → create a new ID
* `main` → the name of the ID

So the layout ID is:

```
main
```

---

```xml
android:layout_width="match_parent"
```

### Explanation

Width of the layout.

`match_parent` means:

➡ take the **full width of the screen**

---

```xml
android:layout_height="match_parent"
```

### Explanation

Height of the layout.

`match_parent` means:

➡ take the **full height of the screen**

---

```xml
tools:context=".MainActivity"
```

### Explanation

This tells Android Studio that this layout belongs to:

```
MainActivity
```

Used only for **design preview**.

---

# 3. LinearLayout

```xml
<LinearLayout
```

### Explanation

Another layout container.

**English:** LinearLayout
**French:** Mise en page linéaire

It arranges elements:

* **vertically** (top → bottom)
* **horizontally** (left → right)

---

```xml
android:layout_width="match_parent"
android:layout_height="match_parent"
```

The LinearLayout fills the **entire screen**.

---

```xml
android:gravity="center_horizontal"
```

### Explanation

Aligns all elements **horizontally to the center**.

Example:

```
      Text
      Button
      Result
```

Everything appears **centered horizontally**.

---

```xml
android:orientation="vertical"
```

### Explanation

The elements inside will be arranged:

⬇ **top → bottom**

Example order:

```
EditText
RadioGroup
Button
TextView
```

---

```xml
tools:layout_editor_absoluteX="1dp"
tools:layout_editor_absoluteY="1dp"
```

These are **design preview attributes only**.

They **do nothing in the real app**.

---

# 4. EditText (Input Field)

```xml
<EditText
```

### Explanation

An **input box where the user can type**.

Example:

User types:

```
100
```

---

```xml
android:id="@+id/ed"
```

### Explanation

ID of this input field.

Your Java code can access it:

```java
EditText ed = findViewById(R.id.ed);
```

---

```xml
android:layout_width="match_parent"
```

The input field takes **the full width of the screen**.

---

```xml
android:layout_height="wrap_content"
```

Height adjusts automatically to the content.

---

```xml
android:gravity="center"
```

Text typed inside will appear:

➡ **centered**

Example:

```
   100
```

---

```xml
android:hint="Donner une valeur"
```

### Explanation

Placeholder text shown before typing.

French:

```
Donner une valeur
```

English:

```
Enter a value
```

---

```xml
android:inputType="numberSigned"
```

### Explanation

Allows the user to type:

✔ numbers
✔ negative numbers

Example:

```
100
-20
```

Keyboard becomes **numeric keyboard**.

---

```xml
android:textSize="30sp"
```

Text size inside the input box.

`sp` = **scale-independent pixels**

Used for text size in Android.

---

```xml
tools:inputType="numberSigned"
```

Preview-only attribute.

---

# 5. RadioGroup

```xml
<RadioGroup
```

### Explanation

A container for **radio buttons**.

Radio buttons allow **only ONE choice**.

Example:

```
( ) Euro → DZD
( ) DZD → Euro
```

User can select **only one**.

---

```xml
android:layout_width="wrap_content"
android:layout_height="wrap_content"
```

Size adjusts automatically.

---

```xml
android:orientation="vertical"
```

Radio buttons appear:

```
Euro → DZD
DZD → Euro
```

one below the other.

---

# 6. First RadioButton

```xml
<RadioButton
```

Creates a selectable option.

---

```xml
android:id="@+id/r1"
```

ID of the radio button.

---

```xml
android:onClick="convert"
```

### Very important

When the radio button is clicked:

➡ it calls a **method in MainActivity**

Example:

```java
public void convert(View v)
```

---

```xml
android:text="Euro ==> DZD"
```

Text displayed.

Meaning:

Convert **Euro to Algerian Dinar**.

---

```xml
android:textSize="25sp"
```

Size of the text.

---

# 7. Second RadioButton

```xml
<RadioButton
    android:id="@+id/r2"
```

Second option.

---

```xml
android:onClick="convert"
```

Also calls the **same function**:

```
convert()
```

---

```xml
android:text="DZD ==> Euro"
```

Convert **Algerian Dinar → Euro**.

---

# 8. Button

```xml
<Button
```

Creates a **button**.

---

```xml
android:id="@+id/button2"
```

ID of the button.

---

```xml
android:onClick="convert"
```

When the button is pressed:

➡ it calls:

```
convert()
```

---

```xml
android:text="Convert"
```

Text displayed on the button.

---

# 9. TextView

```xml
<TextView
```

### Explanation

Displays text on the screen.

Here it will show the **conversion result**.

---

```xml
android:id="@+id/txt"
```

ID used in Java code.

Example:

```java
TextView txt = findViewById(R.id.txt);
```

---

```xml
android:layout_width="wrap_content"
android:layout_height="wrap_content"
```

TextView size adapts to the text.

---

```xml
android:text="Result"
```

Default text displayed.

Example:

```
Result
```

Later the app will replace it with something like:

```
100 Euro = 14500 DZD
```

---

```xml
android:textSize="25sp"
```

Text size.

---

# 10. Closing Layouts

```xml
</LinearLayout>
```

Closes the **LinearLayout**.

---

```xml
</androidx.constraintlayout.widget.ConstraintLayout>
```

Closes the **main layout of the screen**.

---

# Final Structure of the Screen

Your UI looks like this:

```
[      Enter value      ]

( ) Euro → DZD
( ) DZD → Euro

[ Convert Button ]

Result
```

---

# Important Android Concepts You Just Used

| Component        | Role                         |
| ---------------- | ---------------------------- |
| ConstraintLayout | Main screen layout           |
| LinearLayout     | Arranges elements vertically |
| EditText         | User input                   |
| RadioGroup       | Group of choices             |
| RadioButton      | Select conversion direction  |
| Button           | Trigger conversion           |
| TextView         | Show result                  |

---


