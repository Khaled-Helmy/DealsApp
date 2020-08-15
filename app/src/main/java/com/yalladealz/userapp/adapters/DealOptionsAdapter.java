package com.yalladealz.userapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yalladealz.userapp.R;
import com.yalladealz.userapp.interfaces.OptionItemListener;
import com.yalladealz.userapp.model.deals.DealOptions;
import com.yalladealz.userapp.model.deals.OptionDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yalladealz.userapp.util.LogUtil.debug;

public class DealOptionsAdapter extends RecyclerView.Adapter<DealOptionsAdapter.ViewHolder> {

	private Context context;
	private List<DealOptions> options;
	private OptionItemListener listener;
	private boolean[] selections;

	public DealOptionsAdapter(Context context) {
		this.context = context;
		options = new ArrayList<>();
	}

	public void setOptions(List<DealOptions> options) {
		this.options = options;
		selections = new boolean[options.size()];
		Arrays.fill(selections, false);
		notifyDataSetChanged();
	}

	public void setItemListener(OptionItemListener listener) {
		this.listener = listener;
	}
	public int getTotalPrice(){
		int sum = 0;
		for (DealOptions option : options) {
			sum += (Integer.parseInt(option.getFinalPrice())*option.getQuantity());
		}
		return sum;
	}

	public int getTotalQuantity(){
		int sum = 0;
		for (DealOptions option : options) {
			sum += option.getQuantity();
		}
		return sum;
	}
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new ViewHolder(
				LayoutInflater.from(parent.getContext())
				.inflate(R.layout.product_options_list_item,
						parent, false)
		);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		DealOptions option = options.get(position);
		holder.description.setText(option.getOptionDescription().getOptionName());
		holder.price.setText(option.getFinalPrice());
		holder.discount.setText(String.format("%s%%", option.getDealDiscount()));
		option.setQuantity(1);
		holder.optionLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!selections[position]) {
					listener.onOptionItemSelected(option.getFinalPrice());
					holder.optionLayout.setBackgroundColor(Color.GRAY);
					holder.checkBox.setChecked(true);
					selections[position] = true;
				} else {
					listener.onOptionItemUnselected(option.getFinalPrice());
					holder.optionLayout.setBackgroundColor(Color.WHITE);
					holder.checkBox.setChecked(false);
					selections[position] = false;
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		return options.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder{

		TextView description, price, discount;
		View optionLayout;
		CheckBox checkBox;
		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			checkBox = itemView.findViewById(R.id.checkbox);
			optionLayout = itemView.findViewById(R.id.option_layout);
			description = itemView.findViewById(R.id.option_description);
			price = itemView.findViewById(R.id.option_price);
			discount = itemView.findViewById(R.id.option_discount);
		}
	}
}
