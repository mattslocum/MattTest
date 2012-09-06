/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class ALtRelationalOp extends PRelationalOp
{
    private TLtOp _ltOp_;

    public ALtRelationalOp()
    {
        // Constructor
    }

    public ALtRelationalOp(
        @SuppressWarnings("hiding") TLtOp _ltOp_)
    {
        // Constructor
        setLtOp(_ltOp_);

    }

    @Override
    public Object clone()
    {
        return new ALtRelationalOp(
            cloneNode(this._ltOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALtRelationalOp(this);
    }

    public TLtOp getLtOp()
    {
        return this._ltOp_;
    }

    public void setLtOp(TLtOp node)
    {
        if(this._ltOp_ != null)
        {
            this._ltOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ltOp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ltOp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ltOp_ == child)
        {
            this._ltOp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ltOp_ == oldChild)
        {
            setLtOp((TLtOp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
