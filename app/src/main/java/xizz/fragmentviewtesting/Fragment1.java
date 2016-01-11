package xizz.fragmentviewtesting;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Fragment1 extends Fragment {

	private int count = 0;

	MainActivity activity;

	@Bind(R.id.textView)
	TextView textView;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		activity = (MainActivity) context;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment, container, false);
//		textView = (TextView) v.findViewById(R.id.textView);
		ButterKnife.bind(this, v);
		Button button = (Button) v.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.changeText();
			}
		});

		Button newFragBtn = (Button) v.findViewById(R.id.new_fragment_btn);
		newFragBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().replace(R.id.container, new Fragment2())
						.addToBackStack(null).commit();
			}
		});
		return v;
	}

	public void changeText() {
		textView.setText("Count: " + count++);
	}

	@Override
	public void onDestroyView() {
		Log.d("xizz", this.getClass().getSimpleName() + "onDestroyView()");
		super.onDestroyView();
		ButterKnife.unbind(this);
	}

	@Override
	public void onDestroy() {
		Log.d("xizz", this.getClass().getSimpleName() + "onDestroy()");
		super.onDestroy();
	}
}
