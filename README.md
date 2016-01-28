# AndroidTint
AndroidTint（着色）

[![](https://jitpack.io/v/iQuick/AndroidTint.svg)](https://jitpack.io/#iQuick/AndroidTint)

Add it in your root build.gradle at the end of repositories:
>	allprojects {

>		repositories {

>			...

>			maven { url "https://jitpack.io" }

>		}

>	}


Step 2. Add the dependency

>   dependencies {
>
>	        compile 'com.github.iQuick:AndroidTint:-SNAPSHOT'
>
>	}

## Use
setTint

>        AppCompatEditText et1 = (AppCompatEditText) findViewById(R.id.et_1);
         AppCompatEditText et2 = (AppCompatEditText) findViewById(R.id.et_2);

         EmTintUtils.setTint(et1, 0xffff00ff);
         EmTintUtils.setTint(et2, 0xff00ffff);

