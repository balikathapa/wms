package np.edu.kathford.wastemanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCategory extends Fragment {
    EditText category_name, description, price;
    Button submit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        category_name = view.findViewById(R.id.category_name);
        description = view.findViewById(R.id.category_description);
        price = view.findViewById(R.id.category_price);
        submit = view.findViewById(R.id.category_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, des;
                int price1;
                name = category_name.getText().toString();
                des = description.getText().toString();
                price1 = Integer.parseInt(price.getText().toString());
            }
        });
        return view;
    }
}
