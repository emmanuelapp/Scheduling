package br.alexandrenavarro.scheduling.database;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import br.alexandrenavarro.scheduling.R;
import br.alexandrenavarro.scheduling.SchedulingActivity;
import br.alexandrenavarro.scheduling.model.Professional;

/**
 * Created by alexandrenavarro on 14/08/17.
 */

public class ProfessionalHolder extends RecyclerView.ViewHolder{

    private final TextView mNameField;
    private final TextView mSchedulingField;
    private Professional mProfessional;

    public ProfessionalHolder(View itemView) {
        super(itemView);
        mNameField = itemView.findViewById(R.id.txt_name);
        mSchedulingField = itemView.findViewById(R.id.txt_scheduling);

        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SchedulingActivity.class);
            intent.putExtra(SchedulingActivity.EXTRA_PROFESSIONAL, mProfessional);
            view.getContext().startActivity(intent);
        });
    }

    public void bind(Professional professional, String scheduling) {
        mNameField.setText(professional.getName());

        if(!TextUtils.isEmpty(scheduling))
            mSchedulingField.setText(scheduling);

        mProfessional = professional;
    }
}