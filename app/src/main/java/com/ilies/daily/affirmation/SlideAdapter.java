package com.ilies.daily.affirmation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.PagerAdapter;

class SlideAdapter extends PagerAdapter {


    private Context mContext;

    //Slide Content :
    private String[] affirmatioList = new String[]{

            "انا اعيش في سلام وسعادة كل يوم ",
            "انا اقرأ واتعلم كل يوم ",
            "العالم مكان أمن للعيش انا مطمئن ",
            "انا اعيش في امان واستقرار وسلام داخلي ",
            " انا شخص سعيد وايجابي ",
            "صحتي الان اكثر استقرارا",
            "علاقتي مع الاخرين ممتعه وشيقه ",
            "كل شيء يحصل لي انا احدثته بطريقة واعية ",
            "مخاوفي تتلاشى ",
            "انا شخص متفتح على المعلومات الجديدة ",
            "انا اعيش دقائق يومي بسعادة وفرح وانشراح",
            "انا اواجه المخاوف و اتشجع ",
            " الحمد لله عقلي الباطن شريكي في الوصول الى النجاح والسعادة وراحة البال ",
            "انا مغلف بالحب والامان ",
            "كل يوم تزداد صحتي اكثر ",
            "كل يوم ازداد جمال ورشاقة ",
            "عقلي الباطن مغناطيس لأهدافي ",
            "انا سعيده هذا اليوم ",
            "انا انعم بكل ما أحب ليل ونهار ",
            "انا اشعر بالسعادة دون سبب ",
            "كل تخطيط لحياتي بالأمس اعيشة اليوم ",
            "عقلي الباطن يستجيب لتوكيداتي الايجابية ",
            "انا اثق بنفسي "," انا اصنع واقعي ",
            "انا استطيع طرح فكرتي بكل سهولة والاخرين يتقبلوها ",
            "لدي كامل الايمان بمقدراتي ",
            "انا مرن واتغيير ",
            "جميع اهدافي قادر على تحقيقها ",
            "انا اتحرر من الماضي والمشاعر السلبية وارحب بلحظتي ",
            "انا اواجه كل المشاكل والتحديات والصعوبات بشجاعة وحكمة واتغلب عليها ",
            "حياتي رائعة بكل مافيها ", "عقلي رائع ,جسدي رائع ",
            "سعادتي تأتي من الداخل ", "كل يوم اعمل بكل جد واجتهاد وهذا امر ممتاز ",
            "انا انسان طيب ، خلوق ،واثق ومحترم ",
            "لدي القدرة ان اغير نفسي للأفضل ",
            "انا اسامح واتفهم الاخرين ",
            "انا مسؤول عن حياتي ",
            "انا قررت ان اسامح اي شخص واسامح نفسي ",
            "لدي الكثير من الناس التي تساعدني وتساندني ",
            "ابي وامي يحترموني ويشجعوني ويساندوني باستمرار ",
            "انا اقدر نفسي واحترمها والاخرين يحترموني ",
            "انا سعيد بكل احوالي ",
            "انا احب نفسي كما هي بذكائها وجمالها وثقتها ",
            "الطاقة الايجابية تحيط بي من جميع النواحي ",
            "انا اثق ان الله دائماً معي ويستجيب لدعواتي ",
            "الله العظيم ينصرني ،يوفقني ،يرشدني ،يهديني",
            "واستحق وجودهم بحياتي ",
            "انني اؤمن بقوة عقلي الباطن في انجاز هدفي ",
            "من الآن فصاعدا سأتعامل بهدوء ",
            "عقلي يتجدد نشاطه وذكائه ",
            "كرر اللهم اجعلني في افضل احتمال لي ",
            "ذبذباتي الجميلة تتضاعف اتجاه ما أحب",
            "أنا أتمتع في هالة جميلة مشرقه ",
            "هالتي جاذبة للجمال و الاشراق و الصحه ",
            "انا اتخلص من كل شي سلبي يتعلق بهالتي ",
            "انا أجذب كل شي إيجابي الى دائما ",
            "خلايا جسمي تنبض بالجمال و الصحة ",
            "انا اتمتع ببشرة صحية ناعمة و مشرقة ",
            "انا استحق الأجود والاغلى ",
            " انا استحق الافضل من كل شئ ",
            " اللد دائما يبصرنى الى الصواب ",
            "جميع خلايا جسمي تتمتع بالصحه والعافيه وتتشافى ذاتيا ",
            "انا أتحدث عن حقوقي بسهوله واحصل عليها ",
            "علاقتي بجميع من حولي متناغمة ومتآلفة ",
            " لدى طاقة لا نهائية من الحب في أعماقي ",
            "حياتي كل يوم عن يوم تتغير من افضل الى افضل…أزداد سعاده حب.وعي.نجاح.سلام بهجه.رضا.جمال وتألق ",
            " انا نفسي اكثر طمانينه",



    };

    public SlideAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return affirmatioList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView myTextview = new TextView(mContext);
        //setColor :
        myTextview.setTextColor(Color.parseColor("#FFFFFF"));
        //Position :
        myTextview.setGravity(Gravity.CENTER);
        //size :
        myTextview.setTextSize(TypedValue.COMPLEX_UNIT_SP,38);


        //set font :
        Typeface typeface = ResourcesCompat.getFont(mContext, R.font.zahra);
        myTextview.setTypeface(typeface);
        //setText
        myTextview.setText(affirmatioList[position]);
        container.addView(myTextview, 0);
        return myTextview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((TextView) object);
    }


}