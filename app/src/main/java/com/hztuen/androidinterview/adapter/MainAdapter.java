package com.hztuen.androidinterview.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hztuen.androidinterview.R;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private List<String> mDatas;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    public MainAdapter(Context context,List<String> list){
        this.layoutInflater = LayoutInflater.from(context);
        this.mDatas = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.item_main,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_content.setText(mDatas.get(position));
        holder.tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=onItemClickListener){
                    onItemClickListener.onItemClickListener(position);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        AppCompatTextView tv_content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
    public interface OnItemClickListener{
        void  onItemClickListener(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
