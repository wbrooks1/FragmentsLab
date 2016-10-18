package wbrooks1.tacoma.uw.edu.fragmentslab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wbrooks1.tacoma.uw.edu.fragmentslab.course.CourseContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseDetailFragment extends Fragment {

    public static String DETAIL_ARG = "detail_arg";


    public CourseDetailFragment() {
        // Required empty public constructor
    }

    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateCourseItemView((CourseContent.CourseItem)
            args.getSerializable(DETAIL_ARG));
        } else {
            updateCourseItemView(CourseContent.ITEMS.get(0));
        }
    }

    public void updateCourseItemView(CourseContent.CourseItem item) {
        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.course_item_id);
        courseIdTextView.setText(item.id);
        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.course_item_title);
        courseTitleTextView.setText(item.title);
        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.course_item_desc);
        courseShortDescTextView.setText(item.description);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_detail, container, false);
    }

}
