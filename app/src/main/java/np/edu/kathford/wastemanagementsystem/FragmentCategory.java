package np.edu.kathford.wastemanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String price1;
                name = category_name.getText().toString();
                des = description.getText().toString();
                price1 = price.getText().toString();


                //validation for category
                if(name!=null && !name.isEmpty()){
                    Toast.makeText(getActivity(), "Category name is valid", Toast.LENGTH_SHORT).show();
                    if(des!=null && !des.isEmpty() ){
                        Toast.makeText(getActivity(), "Category description is valid", Toast.LENGTH_SHORT).show();
                        if(price1!=null && !price1.isEmpty()){
                            Toast.makeText(getActivity(),"Category price is valid",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            price.setError("Price is invalid");
                        }
                    }
                    else{
                        category_name.setError("Category name is invalid.");
                    }
                }
                else{
                    description.setError("Description is not valid.");
                }
            }
        });
        return view;
    }
}
