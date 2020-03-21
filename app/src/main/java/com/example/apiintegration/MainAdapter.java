package com.example.apiintegration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<Data> data;

    public MainAdapter(ArrayList<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        holder.mId.setText(""+ data.get(position).getId());
        holder.mDesc.setText(""+ data.get(position).getDescription());



//        if(data.get(position).getCredit()!="0"){
//            holder.mAmount.setText("-"+ data.get(position).getCredit());
//
//        }
//        else{

        int debit,credit,amount;

        debit = Integer.parseInt(data.get(position).getDebit());
        credit = Integer.parseInt(data.get(position).getCredit());


        if(debit>0){
            amount = debit;
        }
        else{
            amount = -1*credit;
        }

                //holder.mAmount.setText(""+ data.get(position).getDebit()+"-"+ data.get(position).getCredit());

        holder.mAmount.setText(""+ amount);

//        }


        holder.mTrmode.setText(""+ data.get(position).getTransactionthrough());
        holder.mDate.setText(""+ data.get(position).getTransactiondate());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mId;
        public TextView mDesc;
        public TextView mAmount;
        public TextView mTrmode;
        public TextView mDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.m_id);
            mDesc = itemView.findViewById(R.id.m_desc);
            mAmount  = itemView.findViewById(R.id.m_amount);
            mTrmode = itemView.findViewById(R.id.m_trmode);
            mDate = itemView.findViewById(R.id.m_date);
        }
    }
}
