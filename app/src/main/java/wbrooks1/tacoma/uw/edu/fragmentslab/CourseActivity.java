package wbrooks1.tacoma.uw.edu.fragmentslab;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wbrooks1.tacoma.uw.edu.fragmentslab.course.CourseContent;

public class CourseActivity extends AppCompatActivity implements
        CourseListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        if (findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    new CourseListFragment()).commit();
        }
    }

    @Override
    public void onListFragmentInteraction(CourseContent.CourseItem item) {
        CourseDetailFragment courseDetailFragment = (CourseDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.course_item_frag);

        if (courseDetailFragment != null) {
            courseDetailFragment.updateCourseItemView(item);

        } else {
            courseDetailFragment = new CourseDetailFragment();
            Bundle args = new Bundle();
            args.putSerializable(CourseDetailFragment.DETAIL_ARG, item);
            courseDetailFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, courseDetailFragment)
                    .addToBackStack(null);

            // Commit the transaction
            transaction.commit();

        }

    }
}


