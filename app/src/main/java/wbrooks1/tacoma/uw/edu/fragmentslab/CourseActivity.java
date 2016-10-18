package wbrooks1.tacoma.uw.edu.fragmentslab;

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

    }
}


