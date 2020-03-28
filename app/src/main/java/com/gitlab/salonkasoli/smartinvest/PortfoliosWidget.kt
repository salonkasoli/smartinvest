package com.gitlab.salonkasoli.smartinvest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PortfoliosWidget(
    list: RecyclerView,
    fab: FloatingActionButton
) {

    var fabClickListener: (() -> Unit)? = null

    private val adapter = Adapter()
    private val portfolioRenderer = PortfolioRenderer()

    init {
        list.layoutManager = LinearLayoutManager(list.context)
        list.adapter = adapter

        fab.setOnClickListener {
            fabClickListener?.invoke()
        }
    }

    fun showPortfolios(portfolio: List<Portfolio>) {
        adapter.clear()
        portfolio.forEach {
            adapter.addEntry(it, portfolioRenderer)
        }
        adapter.notifyDataSetChanged()
    }
}

class PortfolioRenderer : Renderer<PortfolioRenderer.Holder, Portfolio> {

    override fun create(parent: ViewGroup): Holder {
        return Holder(parent)
    }

    override fun bind(h: Holder, entry: Portfolio) {
        h.title.text = entry.name
    }

    class Holder(parent: ViewGroup) : BaseViewHolder(R.layout.item_portfolio, parent) {
        val title = findView<TextView>(R.id.title)
    }

}

class Adapter : RecyclerView.Adapter<BaseViewHolder>() {

    val entries = ArrayList<Any>()
    val renderers = ArrayList<Renderer<BaseViewHolder, Any>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return renderers[viewType].create(parent)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(h: BaseViewHolder, position: Int) {
        renderers[position].bind(h, entries[position])
    }

    fun <H : BaseViewHolder, E : Any> addEntry(entry: E, renderer: Renderer<H, E>) {
        entries.add(entry)
        renderers.add(renderer as Renderer<BaseViewHolder, Any>)
    }

    fun clear() {
        entries.clear()
        renderers.clear()
    }

}

open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    constructor(@LayoutRes resId: Int, parent: ViewGroup) :
            this(LayoutInflater.from(parent.context).inflate(resId, parent, false))

    fun <T : View> findView(@IdRes id: Int): T {
        return itemView.findViewById(id)
    }

}

interface Renderer<H : BaseViewHolder, E> {
    fun create(parent: ViewGroup): H
    fun bind(h: H, entry: E)
}