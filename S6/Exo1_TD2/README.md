
# Currency Converter App

---

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

