/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AMulAOp extends PAOp
{
    private TMultOp _multOp_;

    public AMulAOp()
    {
        // Constructor
    }

    public AMulAOp(
        @SuppressWarnings("hiding") TMultOp _multOp_)
    {
        // Constructor
        setMultOp(_multOp_);

    }

    @Override
    public Object clone()
    {
        return new AMulAOp(
            cloneNode(this._multOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMulAOp(this);
    }

    public TMultOp getMultOp()
    {
        return this._multOp_;
    }

    public void setMultOp(TMultOp node)
    {
        if(this._multOp_ != null)
        {
            this._multOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._multOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._multOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._multOp_ == child)
        {
            this._multOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._multOp_ == oldChild)
        {
            setMultOp((TMultOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
