package GUIApp

import GUIApp.Fragmento1
import GUIApp.Fragmento2
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Fragmento1()
            }
            1 -> {
                return Fragmento2()
            }

            else -> {
                return Fragmento1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Cuadrilátero"
            }
            1 -> {
                return "Triangulos"
            }

        }
        return super.getPageTitle(position)
    }
}