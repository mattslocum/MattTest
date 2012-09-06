/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AGtAOp extends PAOp
{
    private TGtOp _gtOp_;

    public AGtAOp()
    {
        // Constructor
    }

    public AGtAOp(
        @SuppressWarnings("hiding") TGtOp _gtOp_)
    {
        // Constructor
        setGtOp(_gtOp_);

    }

    @Override
    public Object clone()
    {
        return new AGtAOp(
            cloneNode(this._gtOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGtAOp(this);
    }

    public TGtOp getGtOp()
    {
        return this._gtOp_;
    }

    public void setGtOp(TGtOp node)
    {
        if(this._gtOp_ != null)
        {
            this._gtOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gtOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._gtOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._gtOp_ == child)
        {
            this._gtOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._gtOp_ == oldChild)
        {
            setGtOp((TGtOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
