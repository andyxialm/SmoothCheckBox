#SmoothCheckBox

### ScreenShot 截图:

![](https://github.com/andyxialm/SmoothCheckBox/blob/master/art/smoothcb.gif?raw=true)

### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|duration|integer|动画持续时间|
|stroke_width|dimension|未选中时边框宽度|
|color_tick|color|对勾颜色|
|color_checked|color|选中时填充颜色|
|color_unchecked|color|未选中时填充颜色|
|color_unchecked_stroke|color|未选中时边框颜色|


## Install (Android Studio 3.1.2)

1. Select `File` > `Project Structure...`

2. Click the green `+` icon (top left) 

 **or** Press **ALT+INSERT** to open the "new module dialog.

3. Select `Import Gradle Project`

4. Select the directory where you download and unzipped the project. 

 **or** 
 - git clone https://github.com/andyxialm/SmoothCheckBox.git
 - specifically `SmoothCheckBox`

5. The dialog will present two modules `:library` and `:sample`, check `:library` checkbox. Then choose `Finish`.

6. Open your projects `settings.gradle(Project Settings)` file. Add a new line `:library`

7. Open `build.gradle(Module:app)` in the 

```
dependencies {  
		...
		implementation project(':library')
}
```
8. Gradle `sync` your project, to complete the changes.


## Sample Usage 使用


```java
 
    setChecked(boolean checked);                   // 默认不带动画，若需要动画 调用重载方法
    setChecked(boolean checked, boolean animate);  // 参数: animate 是否显示动画
```


```java

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final SmoothCheckBox scb = (SmoothCheckBox) findViewById(R.id.scb);
        scb.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                Log.d("SmoothCheckBox", String.valueOf(isChecked));
            }
        });
    }    
```

## About me

An android developer in Beijing.

Welcome to [offer me](mailto:andyxialm@gmail.com). :smiley:

## License

    Copyright 2015, 2016 andy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
