package de.madcyph3r.example.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import de.madcyph3r.example.FragmentIndex;
import de.madcyph3r.example.R;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawerListener;
import de.madcyph3r.materialnavigationdrawer.item.MaterialHeadItem;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialSection;
import de.madcyph3r.materialnavigationdrawer.tools.RoundedCornersDrawable;

/**
 * Created by marc on 23.02.2015.
 */
public class BackPatternCustom extends MaterialNavigationDrawer {

    MaterialNavigationDrawer drawer = null;

    @Override
    public int headerType() {
        // set type. you get the available constant from MaterialNavigationDrawer class
        return MaterialNavigationDrawer.DRAWERHEADER_HEADITEMS;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        drawer = this;

        MaterialMenu menu = new MaterialMenu();

        // first section is loaded
        MaterialSection section1 = this.newSection("Section 1", this.getResources().getDrawable(R.drawable.ic_favorite_black_36dp), new FragmentIndex(), false, menu);
        MaterialSection section2 = this.newSection("Section 2", this.getResources().getDrawable(R.drawable.ic_list_black_36dp), new FragmentIndex(), false, menu);
        MaterialSection section3 = this.newSection("Section 3", this.getResources().getDrawable(R.drawable.ic_list_black_36dp), new FragmentIndex(), false, menu);
        MaterialSection section4 = this.newSection("Section 4", this.getResources().getDrawable(R.drawable.ic_list_black_36dp), new FragmentIndex(), false, menu);

        // use bitmap and make a circle photo
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.app_drawer_icon);
        final RoundedCornersDrawable drawableAppIcon = new RoundedCornersDrawable(getResources(), bitmap);

        // create Head Item
        MaterialHeadItem headItem = new MaterialHeadItem(this, "F HeadItem", "F Subtitle", drawableAppIcon, R.drawable.mat5, menu, 0);

        // add head Item (menu will be loaded automatically)
        this.addHeadItem(headItem);

        // set Pattern
        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_CUSTOM);
    }

    @Override
    protected MaterialSection backToSection(MaterialSection currentSection) {
        // info: don't forget, devisor is in the section list, you can't cast it to MaterialSection
        // you must caught the exception or work with the current headitem, because you now the menu order ;)
        MaterialSection section;
        switch(currentSection.getPosition()) {
            case 3:
                section = (MaterialSection) this.getCurrentMenu().getSections().get(2);
                this.changeToolbarColor((MaterialSection) section); // remember to change the toolbar color
                break;
            case 2:
                section = (MaterialSection) this.getCurrentMenu().getSections().get(1);
                this.changeToolbarColor((MaterialSection) section); // remember to change the toolbar color
                break;
            case 1:
                section = (MaterialSection) this.getCurrentMenu().getSections().get(0);
                this.changeToolbarColor((MaterialSection) section); // remember to change the toolbar color
                break;
            default:
                section = super.backToSection(currentSection); // exit from activity
                break;
        }

        return section;
    }
}
