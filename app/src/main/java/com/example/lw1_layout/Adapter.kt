package com.example.lw1_layout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lw1_layout.databinding.HeaderItemBinding
import com.example.lw1_layout.databinding.ProfileItemBinding
import com.example.lw1_layout.databinding.TarifItemBinding
import com.example.lw1_layout.databinding.UslugaItemBinding
import java.lang.Error

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList = mutableListOf<Data>(
//        Profile(check = 155.78f,depth = 6274.99f),
//        Header(text = "Тарифы"),
//        Tarif(name = "Спид-Мэн", price = 999.99f, speed = "100 Гб/сек"),
//        Tarif(name = "Улиточка", price = 0.1f, speed = "1 б/минуту"),
//        Header(text = "Пользователь"),
//        Usluga(text = R.drawable.sokrat.toString(),image = R.drawable.sokrat),
//        Usluga(text = R.drawable.home.toString(),image = R.drawable.home) //"Тридевятое кр,Хельмова Падь,Хата с краю "
    )

    public fun addToDataList(list: List<Data>?){
        if (list != null) {
            dataList.addAll(list)
        }
    }
    public fun addToDataList(ject: Data?){
        if (ject != null) {
            dataList.add(ject)
        }
    }
    public fun addHeader(text: String){
        dataList.add(Header(text = text))
    }

    class HeaderHolder(item: View): RecyclerView.ViewHolder(item) {

        private val binding = HeaderItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(header: Header) = with(binding) {

            headerText.text = header.text;

        }

    }
    class ProfileHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = ProfileItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(profile: Profile) = with(binding) {

            check.text = profile.check.toString() + " ₽";
            depth.text = profile.depth.toString() + " ₽";

        }

    }
    class TarifHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = TarifItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(tarif: Tarif) = with(binding) {

            name.text = "«" + tarif.name + "»";
            price.text = tarif.price.toString() + " ₽/мес";
            speed.text = tarif.speed;

        }

    }
    class UslugaHolder(item: View): RecyclerView.ViewHolder(item) {

        private val binding = UslugaItemBinding.bind(item)

        fun bind(usluga: Usluga) = with(binding) {

            uslugaText.text = usluga.text;
            uslugaImage.setImageResource(usluga.image);

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.tarif_item -> {

                TarifHolder(LayoutInflater.from(parent.context).inflate(viewType, parent,false))

            }
            R.layout.usluga_item -> {

                UslugaHolder(LayoutInflater.from(parent.context).inflate(viewType, parent,false))

            }
            R.layout.profile_item -> {

                ProfileHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

            }
            R.layout.header_item -> {

                HeaderHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

            }
            else -> { throw Error("") }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TarifHolder -> {
                holder.bind(dataList[position] as Tarif)
            }
            is UslugaHolder -> {
                holder.bind(dataList[position] as Usluga)
            }
            is ProfileHolder -> {
                holder.bind(dataList[position] as Profile)
            }
            is HeaderHolder -> {
                holder.bind(dataList[position] as Header)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is Tarif -> R.layout.tarif_item
            is Usluga -> R.layout.usluga_item
            is Profile -> R.layout.profile_item
            is Header -> R.layout.header_item
            else -> throw IllegalArgumentException("нет такого пункта")
        }
    }

}