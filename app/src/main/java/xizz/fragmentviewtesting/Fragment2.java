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

public class Fragment2 extends Fragment {

	MainActivity activity;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		activity = (MainActivity) context;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment, container, false);
		TextView textView = (TextView) v.findViewById(R.id.textView);
		textView.setText("Fragment2");

		Button button = (Button) v.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.changeText();
			}
		});
		return v;
	}

	@Override
	public void onDestroyView() {
		Log.d("xizz", this.getClass().getSimpleName() + "onDestroyView()");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		Log.d("xizz", this.getClass().getSimpleName() + "onDestroy()");
		super.onDestroy();
	}
}
